import '../style/ProgressBar.css';
import {useState} from "react";

export default function ProgressBar(props) {
    const [percent, setPercent] = useState(props.percentage)

    function inputHandler(e){
        setPercent(e.target.value)
    }

    const text = props.size === "small" ? '' : `${percent}% done`

    return (
        <div className={"flex"}>
            <div className={`progress-bar ${props.size}`}>
                <div
                    className={"progress"}
                    style={{width: `${percent}%`, backgroundColor: '#51c25a'}}
                >
                    <span className={"percentage"}>{text}</span>
                </div>
            </div>
            <input type={"number"}
                   min={0}
                   max={100}
                   onChange={inputHandler}
                   value={percent}
            />
        </div>
    )
}