
export default function ProjectLink(props){
    return(
        <a href="#" onClick={() => {
            props.changeComponent('Latest');
            props.changeProject(props.id);
        }}>
            {props.name}
        </a>
    )
}