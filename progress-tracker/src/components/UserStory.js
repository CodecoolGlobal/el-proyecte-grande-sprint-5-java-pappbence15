import {Star} from "./Star";

export default function UserStory(props){
    return(
        <li>
            {props.story.name}
            <Star full={props.isFavourite}/>
        </li>
    )
}