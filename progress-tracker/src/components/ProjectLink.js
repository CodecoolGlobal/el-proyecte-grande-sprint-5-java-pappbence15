
export default function ProjectLink(props){
    return(
        <a onClick={() => {
            props.changeComponent('Latest');
            props.changeProject(props.id);
        }}>
            {props.name}
        </a>
    )
}