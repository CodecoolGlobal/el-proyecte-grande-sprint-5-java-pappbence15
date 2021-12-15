import logo from './logo.svg';
import './App.css';
import Navbar from "./Navbar";
import Header from "./Header";
import {useState} from "react";
import ProjectList from "./ProjectList";

function App() {
    const [component, setComponent] = useState('All')
    const changeComponent = (newComponent) => setComponent(newComponent)
  return (
      <div>
    <div className="App">
        <Header/>
        <Navbar change={changeComponent}/>
    </div>
          <div>
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
            return (<p>settings</p>)
    }
}
export default App;
