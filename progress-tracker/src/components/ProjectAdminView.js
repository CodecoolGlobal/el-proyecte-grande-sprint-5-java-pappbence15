import {useEffect, useState} from "react";
import ProgressBar from "./ProgressBar";
import Grid from "@mui/material/Grid";
import BasicTabs from "./UserStoryTab";
import Typography from "@mui/material/Typography";
import * as React from "react";
import {Box, createTheme, Fab, ListItem, ListItemIcon, ListItemText, Paper, Popover} from "@mui/material";
import BasicPopover from "./layout/InfoPopover";
import BarChartIcon from '@mui/icons-material/BarChart';
import AssignmentIcon from '@mui/icons-material/Assignment';
import List from "@mui/material/List";

export default function ProjectAdminView(props) {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [project, setProject] = useState(null);

    useEffect(() => {

        const url = 'admin/project/' + props.projectId

        fetch(url)
            .then(res => res.json())
            .then(
                (result) => {
                    setProject(result);
                    setIsLoaded(true);
                },
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            )
    }, [] )

    if (error) {
        return <div>Error: {error.message}</div>;
    } else if (!isLoaded) {
        return <div>Loading...</div>;
    } else {
        const allStories = project.userStories;

        return (
            <div style={{"marginTop": "4vmin"}}>
                <Grid spacing={{xs: 2, sm: 2}} container columns={{ xs: 1, sm: 1, md: 1 }}>
                <Grid item minWidth={'375px'}>
                <Paper elevation={3}>
                    <Box role={"presentation"}>
                        <List>
                            <ListItem key={'Project'}>
                                <ListItemIcon>
                                    <AssignmentIcon fontSize={"large"}/>
                                </ListItemIcon>
                                <ListItemText>
                                    <Typography variant={"h2"}>{project.name}</Typography>
                                </ListItemText>
                            </ListItem>
                            <ListItem>
                                <ListItemIcon>
                                    <BarChartIcon fontSize={"large"}/>
                                </ListItemIcon>
                                <ListItemText>
                                    <ProgressBar size={"small"}
                                                 percentage={Math.round(project.percentage * 100)}
                                    />
                                </ListItemText>
                            </ListItem>
                            <ListItem>
                                <ListItemIcon>
                                    <BasicPopover owner={project.owner.name} admins={project.admins}/>
                                </ListItemIcon>
                                <ListItemText>
                                    More
                                </ListItemText>
                            </ListItem>
                        </List>
                    </Box>
                </Paper>
                </Grid>
                <Grid item>
                    <Typography variant={"h3"}>User stories</Typography>
                <Grid container spacing={{ xs: 2, md: 2 }} columns={{ xs: 1, sm: 1, md: 1 }}>
                    <BasicTabs userStories={allStories}/>
                </Grid>
                </Grid>
                </Grid>
            </div>
        );
    }
}