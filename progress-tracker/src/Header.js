import logo from './logo.svg';
function Header(){
    const name = 'Name of the Brand';

    return(
        <div>
            {renderHeader(name)}
        </div>
    )
}

function renderHeader(name){
    return(
        <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <h1 className="App-name">
                {name}
            </h1>
        </header>
    )
}

export default Header;