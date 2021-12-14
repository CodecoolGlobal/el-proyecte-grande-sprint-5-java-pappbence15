import logo from './logo.svg';
function Navbar(){
    const projects = 'Projects';
    const latest = 'Latest';
    const all = 'All';

    return(
        <div>
            <div>
                {logo}
            </div>
            <div>
                {renderNavLink('#', projects)}
            </div>
            <div>
                {renderNavLink('/', latest)}
            </div>
            <div>
                {renderNavLink('/', all)}
            </div>
        </div>
    )
}

function renderNavLink(url, name){
    return(
        <a href={url}>
            {name}
        </a>
    )
}

export default Navbar;