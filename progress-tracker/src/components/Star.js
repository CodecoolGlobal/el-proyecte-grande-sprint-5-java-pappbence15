import {useState} from "react";

export function Star(props) {
    const [isFull, setFull] = useState(props.full)

    function onClick() {
        setFull(prev=>!prev);
        fetch(`/${props.id}/favourite`, {method:'POST'});
    }

    return (
        <span className={"noselect"} onClick={onClick}>{isFull? "★":"☆"}</span>
    )
}