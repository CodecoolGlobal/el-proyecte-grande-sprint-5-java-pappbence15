import {useEffect, useState} from "react";
import ProjectList from "./components/ProjectList";
import ProjectAdminView from "./components/ProjectAdminView";
import Settings from "./Settings";
import {Container, createTheme, CssBaseline, ThemeProvider} from "@mui/material";
import AppBar from "./components/layout/AppBar";
import './style/Header.css';

function App() {
    const [component, setComponent] = useState('All')
    const [projectId, setProjectId] = useState('')
    const [darkMode, setDarkMode] = useState(false);
    const [userType, setUserType] = useState('');
    const setTheme = (mode) => setDarkMode(mode);
    const changeComponent = (newComponent) => setComponent(newComponent)
    const changeProjectId = (newId) => setProjectId(newId)

    let theme;

    const darkTheme = createTheme({
        palette: {
            type: 'dark',
            primary: {
                main: '#1976d2',
            },
            secondary: {
                main: '#ffd600',
            },
            info: {
                main: '#2196f3',
            },
            background: {
                default: '#070825',
                paper: 'rgba(26,35,126,0.90)',
            },
            text: {
                primary: '#ffffff',
                hint: '#bbdefb',
                secondary: '#bbdefb',
            },
            warning: {
                main: '#7c4dff',
            },
        },
    });

    const lightTheme = createTheme({
        palette: {
            type: 'light',
            primary: {
                main: '#5c6bc0',
            },
            secondary: {
                main: '#ff4081',
            },
            background: {
                paper: '#e8eaf6',
            },
        },
    })



    useEffect(() => getThemeSetting(setDarkMode, setUserType), [])
    if(darkMode){
        theme = darkTheme
    }else{
        theme = lightTheme

    }

  return (
      <ThemeProvider theme={theme}>
          <CssBaseline/>
        <div id='main-div'>
            <div className="App">
                <AppBar changeComponent={changeComponent} setTheme={setTheme} currentTheme={darkMode}/>
                {/*<Footer owner={"©Hello World KFT"} creators={["Sjpeti97", "pappbence15"]} links={["https://github.com/Sjpeti97", "https://github.com/pappbence15"]}/>*/}

            </div>
            <Container maxWidth="lg">
                {renderDynamicComponent(component, changeComponent, projectId, changeProjectId, setTheme, darkMode, userType)}
            </Container>
        </div>
      </ThemeProvider>
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
