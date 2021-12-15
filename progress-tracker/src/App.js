import './style/App.css';
import './style/Navbar.css';
import './style/Header.css'
import './style/Footer.css'
import './style/Settings.css';
import Header from "./Header";
import Footer from "./Footer";
import {useState} from "react";
import ProjectList from "./ProjectList";
import Settings from "./Settings";

function App() {
    const [component, setComponent] = useState('All')
    const changeComponent = (newComponent) => setComponent(newComponent)
  return (
      <div>
    <div className="App">
        <Header name={"Name of the Brand"} changeComponent={changeComponent}/>
        <Footer owner={"©Hello World KFT"} creators={["csillalukacs", "Sjpeti97", "pappbence15", "JustBenS1"]} links={['https://github.com/csillalukacs', "https://github.com/Sjpeti97", "https://github.com/pappbence15", "https://github.com/JustBenS1"]}/>
    </div>
          <div className='dynamic-component-container'>
              {renderDynamicComponent(component)}
          </div>
      </div>
  );
}
function renderDynamicComponent(component){
    switch (component){
        case 'All':
            return(<p>detailed view of one project</p>)
        case 'Latest':
            return (<p>overview of one project</p>)
        case 'Projects':
            return (<ProjectList userType={"admin"}/>)
        case 'Settings':
            return <Settings/>
    }
}
export default App;
