import './App.css';
import Navbar from "./Navbar";
import {useState} from "react";

function App() {
    const [component, setComponent] = useState('All')
    const changeComponent = (newComponent) => setComponent(newComponent)
  return (
      <div>
    <div className="App">
      <header className="App-header">
      </header>
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
            return(<p>test1</p>)
        case 'Latest':
            return (<p>test2</p>)
        case 'Projects':
            return (<p>test3</p>)
    }
}
export default App;
