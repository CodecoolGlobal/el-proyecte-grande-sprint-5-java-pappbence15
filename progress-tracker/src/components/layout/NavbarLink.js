export function NavbarLink(props) {
    return (
        <a onClick={() => props.changeComponent(props.name)} className='navbar-link'>
            {props.name}
        </a>
    )
}