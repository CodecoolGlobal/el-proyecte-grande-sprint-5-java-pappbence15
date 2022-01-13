import {Card, CardContent} from "@mui/material";
import Grid from "@mui/material/Grid";
const style={
    fontSize: 25,
    color: "white"
}
export default function ProjectLink(props){
    return(
        <Grid item xs={1} sm={1} md={1} marginTop={3}>
            <Card elevation={0}
                  sx={{minWidth: 275}}
                  style={{backgroundColor: "#5F636770"}}
                  onClick={() => {
                    props.changeComponent('Latest');
                    props.changeProject(props.id);
                  }}>
                <CardContent>
                    <a  style={style}>
                        {props.name}
                    </a>
                </CardContent>
            </Card>
        </Grid>
    )
}