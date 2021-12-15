import './style/App.css';
import './style/Navbar.css';
import './style/Header.css'
import './style/Footer.css'
import Navbar from "./Navbar";
import Header from "./Header";
import Footer from "./Footer";
import {useState} from "react";
import ProjectList from "./components/ProjectList";
import ProjectAdminView from "./components/ProjectAdminView";

function App() {
    const [component, setComponent] = useState('All')
    const [projectId, setProjectId] = useState('')
    const changeComponent = (newComponent) => setComponent(newComponent)
    const changeProjectId = (newId) => setProjectId(newId)
  return (
      <div>
    <div className="App">
        <Header name={"Name of the Brand"} changeComponent={changeComponent}/>
        <Footer owner={"©Hello World KFT"} creators={["csillalukacs", "Sjpeti97", "pappbence15", "JustBenS1"]} links={['https://github.com/csillalukacs', "https://github.com/Sjpeti97", "https://github.com/pappbence15", "https://github.com/JustBenS1"]}/>
    </div>
          <div className='dynamic-component-container'>
              {renderDynamicComponent(component, changeComponent, projectId, changeProjectId)}
          </div>
      </div>
  );
}
function renderDynamicComponent(component, changeComponent, projectId, changeProject){
    switch (component){
        case 'All':
            if (projectId) {
                return (<ProjectAdminView projectId={projectId}
                                          detailedView={true}
                />)
            }
            else {
                return (<ProjectList userType={"admin"}
                                     changeComponent={changeComponent}
                                     changeProject={changeProject}
                                     projectId={projectId}

                />)
            }
        case 'Latest':
            if (projectId) {
                return (<ProjectAdminView projectId={projectId}
                                          detailedView={false}

                />)
            }
            else {
                return (<ProjectList userType={"admin"}
                                     changeComponent={changeComponent}
                                     changeProject={changeProject}
                                     projectId={projectId}
                />)
            }
        case 'Projects':
            return (<ProjectList userType={"admin"}
                                 changeComponent={changeComponent}
                                 changeProject={changeProject}
                                 projectId={projectId}
            />)
        case 'Settings':
            return (<p>settings</p>)
    }
}
export default App;
