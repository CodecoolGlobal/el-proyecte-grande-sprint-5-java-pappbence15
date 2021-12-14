function Navbar(props){
    const projects = 'Projects';
    const latest = 'Latest';
    const all = 'All';

    return(
        <div>
            <div>
                <NavbarLink url={'#'} name={projects} changeComponent={props.change}/>
            </div>
            <div>
                <NavbarLink url={'#'} name={latest} changeComponent={props.change}/>
            </div>
            <div>
                <NavbarLink url={'#'} name={all} changeComponent={props.change}/>
            </div>
        </div>
    )
}

function NavbarLink(props){
    return(
        <a href={props.url} onClick={() => props.changeComponent(props.name)}>
            {props.name}
        </a>
    )
}

export default Navbar;