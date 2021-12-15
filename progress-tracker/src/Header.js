import logo from './logo.svg';
import Navbar from "./Navbar";

function Header(){
    return(
        <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <Navbar/>
        </header>
    )
}

export default Header;