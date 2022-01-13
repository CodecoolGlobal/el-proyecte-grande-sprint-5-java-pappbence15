export default function ProjectLink(props){
    return(
        <a onClick={() => {
            props.changeComponent('Latest');
            props.changeProject(props.id);
        }} style={{fontSize: 25}}>
            {props.name}
        </a>
    )
}