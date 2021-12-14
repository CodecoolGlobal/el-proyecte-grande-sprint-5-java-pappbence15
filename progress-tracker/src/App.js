import './App.css';
import Navbar from "./Navbar";
import {useState} from "react";

function App() {
    const [component, setComponent] = useState('All')
    const changeComponent = (newComponent) => setComponent(newComponent)
    console.log(component)
  return (
    <div className="App">
      <header className="App-header">
      </header>
        <Navbar change={changeComponent}/>
    </div>
  );
}

export default App;
