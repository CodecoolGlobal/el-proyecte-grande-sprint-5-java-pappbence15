import '../style/ProgressBar.css';

export default function ProgressBar(props){
    const hue = ((props.percentage/100) * 120).toString(10);
    const color = ["hsl(", hue, ",70%,50%)"].join("");
    return(
        <div className={"progress-bar"}>
        <div
            className={"progress"}
            style={{width:`${props.percentage}%`, backgroundColor: `${color}`}}
        >
            <span className={"percentage"}>{props.percentage}% done</span>
        </div>
        </div>
    )
}