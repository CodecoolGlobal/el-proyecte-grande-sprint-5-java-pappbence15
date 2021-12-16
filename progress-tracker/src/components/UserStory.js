import {Star} from "./Star";
import ProgressBar from "./ProgressBar"
import {Card, CardContent, Typography} from "@mui/material";

export default function UserStory(props){
    return(
        <Card sx={{minWidth: 275}}>
            <CardContent>
                <Typography sx={{ fontSize: 20 }} color="text" gutterBottom>
                    {props.story.name}
                </Typography>
                <ProgressBar size={"small"}
                             percentage={100*(props.story.currentPercent)}/>
                <Star full={props.story.favourite} id={props.story.id}/>
            </CardContent>
        </Card>
    )
}