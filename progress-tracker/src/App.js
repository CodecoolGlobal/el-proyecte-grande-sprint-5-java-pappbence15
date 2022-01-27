import './style/App.css';
import './style/Navbar.css';
import './style/Header.css'
import './style/Footer.css'
import './style/Settings.css';
import Header from "./components/layout/Header";
import Footer from "./components/layout/Footer";
import './style/DarkMode.css'
import {useEffect, useState} from "react";
import ProjectList from "./components/ProjectList";
import ProjectAdminView from "./components/ProjectAdminView";
import Settings from "./Settings";
import {Container} from "@mui/material";
import AppBar from "./components/layout/AppBar";

function App() {
    const [component, setComponent] = useState('All')
    const [projectId, setProjectId] = useState('')
    const [darkMode, setDarkMode] = useState(true);
    const [userType, setUserType] = useState('');
    const setTheme = (mode) => setDarkMode(mode);
    const changeComponent = (newComponent) => setComponent(newComponent)
    const changeProjectId = (newId) => setProjectId(newId)


    let backgroundColor;



    useEffect(() => getThemeSetting(setDarkMode, setUserType), [])
    if(darkMode){
        backgroundColor = "dark-mode-background";
    }else{
        backgroundColor = 'light-mode-background';

    }

  return (
        <div className={backgroundColor} id='main-div'>
            <div className="App">
                <AppBar/>
                {/*<Header name={"Name of the Brand"} changeComponent={changeComponent}/>*/}
                <Footer owner={"©Hello World KFT"} creators={["Sjpeti97", "pappbence15"]} links={["https://github.com/Sjpeti97", "https://github.com/pappbence15"]}/>

            </div>
            <Container maxWidth="sm">
                {renderDynamicComponent(component, changeComponent, projectId, changeProjectId, setTheme, darkMode, userType)}
            </Container>
        </div>
  );
}

function renderDynamicComponent(component, changeComponent, projectId, changeProject, setTheme, darkMode, userType){
    switch (component){
        case 'All':
            if (projectId) {
                return (<ProjectAdminView projectId={projectId}
                                          detailedView={true}
                />)
            } else {
                return (<ProjectList changeComponent={changeComponent}
                                     changeProject={changeProject}
                                     projectId={projectId}
                />)
            }
        case 'Latest':
            if (projectId) {
                return (<ProjectAdminView projectId={projectId}
                                          detailedView={false}
                />)
            } else {
                return (<ProjectList changeComponent={changeComponent}
                                     changeProject={changeProject}
                                     projectId={projectId}
                />)
            }
        case 'Projects':
            return (<ProjectList changeComponent={changeComponent}
                                 changeProject={changeProject}
                                 projectId={projectId}
            />)
        case 'Settings':
            return <Settings setTheme={setTheme} darkMode={darkMode}/>

        case 'Logout':
            return (
                <div>
                    <h1>Are you sure?</h1>
                    <a href={"http://localhost:8080/logout"}>Yes, log me out </a>
                    <br/>
                    <a href={"/"}>No, stay here </a>
                </div>
            )
    }
}


function getThemeSetting(setTheme, setUserType){
    fetch("/settings/darkMode")
        .then(res => res.json())
        .then(result => {
            console.log(result)
            setTheme(result)
        })
}


export default App;
