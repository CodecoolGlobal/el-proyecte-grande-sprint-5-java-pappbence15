import {Card, CardContent} from "@mui/material";
import Grid from "@mui/material/Grid";

export default function ProjectLink(props){
    return(
        <Grid item xs={1} sm={1} md={1} marginTop={3}>
            <Card elevation={0}
                  sx={{minWidth: 275}}
                  style={{backgroundColor: "grey"}}
                  onClick={() => {
                    props.changeComponent('Latest');
                    props.changeProject(props.id);
                  }}>
                <CardContent>
                    <a  style={{fontSize: 25}}>
                        {props.name}
                    </a>
                </CardContent>
            </Card>
        </Grid>
    )
}