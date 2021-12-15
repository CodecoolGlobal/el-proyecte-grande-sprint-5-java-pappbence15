export function NavbarLink(props) {
    return (
        <a href={props.url} onClick={() => props.changeComponent(props.name)} className='navbar-link'>
            {props.name}
        </a>
    )
}