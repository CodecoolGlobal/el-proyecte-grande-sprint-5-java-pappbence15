import {Star} from "./Star";
import {Card, CardContent, Fab, Typography} from "@mui/material";
import EditIcon from '@mui/icons-material/Edit';
import { positions } from '@mui/system';



export default function UserStory(props){
    return(
        <Card sx={{minWidth: 275}} style={{marginTop: '5%'}}>
            <CardContent>
                <Typography sx={{ fontSize: 20 }} gutterBottom>
                    {props.story.name}
                </Typography>
                <Fab color="secondary" aria-label="edit" size={"small"} style={{position: "absolute", marginLeft: "10%"}}>
                    <EditIcon />
                </Fab>
                <Star full={props.story.favourite} id={props.story.id}/>
            </CardContent>
        </Card>
    )
}