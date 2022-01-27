import {NavbarLink} from "./NavbarLink";

function Navbar(props){
    const projects = 'Projects';
    const latest = 'Latest';
    const all = 'All';
    const settings = 'Settings'
    const logout = 'Logout'

    return(
        <div className='navbar-container'>
            <div className='navbar-link-container'>
                <NavbarLink name={projects} changeComponent={props.change}/>
            </div>
            <div className='navbar-link-container'>
                <NavbarLink name={latest} changeComponent={props.change}/>
            </div>
            <div className='navbar-link-container'>
                <NavbarLink name={all} changeComponent={props.change}/>
            </div>
            <div className='navbar-link-container'>
                <NavbarLink name={settings} changeComponent={props.change}/>
            </div>
            <div className='navbar-link-container'>
                <NavbarLink name={logout} changeComponent={props.change}/>
            </div>
        </div>
    )
}

export default Navbar;