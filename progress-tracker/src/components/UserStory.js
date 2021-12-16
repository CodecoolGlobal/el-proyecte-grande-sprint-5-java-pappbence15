import {Star} from "./Star";

export default function UserStory(props){
    return(
        <li>
            {props.story.name}
            <Star full={props.story.favourite} id={props.story.id}/>
        </li>
    )
}