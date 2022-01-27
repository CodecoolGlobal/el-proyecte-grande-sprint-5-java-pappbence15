import {useEffect, useState} from "react";
import ProjectLink from "./ProjectLink";
import {Card, CardContent, Fab, Paper} from "@mui/material";
import Grid from "@mui/material/Grid";
import AddNewProjectModal from "./AddNewProjectModal";
import DescriptionAlert from "./layout/LogInAlert";

export default function ProjectList(props){
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);

    useEffect(() => {
        let url = '/projects'
        fetch(url)
            .then(res => res.json())
            .then(
                (result) => {
                    setIsLoaded(true);
                    setItems(result);
                },
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            )
    }, [])

    if (error) {
        return (
            <div>
                <DescriptionAlert/>
            </div>
        );
    } else if (!isLoaded) {
        return <div>Loading...</div>;
    } else {
        return (
            <Grid container spacing={{ xs: 2, md: 2 }} columns={{ xs: 1, sm: 1, md: 1 }} direction={"row"}>
                {items.map(item => (
                    <ProjectLink name={item.name}
                             url={'/admin/project/' + item.id}
                             id={item.id}
                             changeComponent={props.changeComponent}
                             changeProject={props.changeProject}>
                    </ProjectLink>
                ))}
                <Grid item xs={1} sm={1} md={1} marginTop={3}>
                    <AddNewProjectModal />
                </Grid>
            </Grid>
        );
    }
}