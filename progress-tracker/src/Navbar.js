function Navbar(props){
    const projects = 'Projects';
    const latest = 'Latest';
    const all = 'All';
    const settings = 'Settings'

    return(
        <div className='navbar-container'>
            <div className='navbar-link-container'>
                <NavbarLink url={'#'} name={projects} changeComponent={props.change}/>
            </div>
            <div className='navbar-link-container'>
                <NavbarLink url={'#'} name={latest} changeComponent={props.change}/>
            </div>
            <div className='navbar-link-container'>
                <NavbarLink url={'#'} name={all} changeComponent={props.change}/>
            </div>
            <div className='navbar-link-container'>
                <NavbarLink url={'#'} name={settings} changeComponent={props.change}/>
            </div>
        </div>
    )
}

function NavbarLink(props){
    return(
        <a href={props.url} onClick={() => props.changeComponent(props.name)} className='navbar-link'>
            {props.name}
        </a>
    )
}

export default Navbar;