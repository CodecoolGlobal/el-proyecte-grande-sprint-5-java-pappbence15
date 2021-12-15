import {Star} from "./Star";

export default function UserStory(props){
    return(
        <p>
            <Star full={props.isFavourite}/>
            {props.story.name}
        </p>
    )
}