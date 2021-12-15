import './style/App.css';
import './style/Navbar.css';
import './style/Header.css'
import './style/Footer.css'
import Navbar from "./Navbar";
import Header from "./Header";
import Footer from "./Footer";
import {useState} from "react";

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
            return(<p>test1</p>)
        case 'Latest':
            return (<p>test2</p>)
        case 'Projects':
            return (<p>test3</p>)
        case 'Settings':
            return (<p>test4</p>)
    }
}
export default App;
