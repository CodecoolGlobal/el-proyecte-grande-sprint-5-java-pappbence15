import {Card, CardContent, Fab} from "@mui/material";
import Grid from "@mui/material/Grid";
import Button from "@mui/material/Button";
import AddIcon from '@mui/icons-material/Add';
import EditIcon from "@mui/icons-material/Edit";
import DeleteForeverIcon from '@mui/icons-material/DeleteForever';

export default function ProjectLink(props){
    return(
        <Grid item xs={1} sm={1} md={1} marginTop={3}>
            <Card elevation={3}
                  sx={{minWidth: 275}}>
                <CardContent>
                    <Grid container spacing={2} alignItems={'flex-end'}>
                        <Grid item>
                    <Button color={"secondary"} onClick={() => {
                        props.changeComponent('Latest');
                        props.changeProject(props.id);
                    }}>{props.name}</Button>
                        </Grid>
                        <Grid item>
                    <Fab color="primary" aria-label="add" size={"small"}>
                        <AddIcon />
                    </Fab>
                        </Grid>
                        <Grid item>
                    <Fab color="secondary" aria-label="edit" size={"small"}>
                        <EditIcon/>
                    </Fab>
                        </Grid>
                        <Grid item>
                    <Fab color="warning" aria-label="delete" size={"small"}>
                        <DeleteForeverIcon/>
                    </Fab>
                        </Grid>
                    </Grid>
                </CardContent>
            </Card>
        </Grid>
    )
}