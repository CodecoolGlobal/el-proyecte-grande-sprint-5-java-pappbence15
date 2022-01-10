import {useEffect, useState} from "react";
import UserStory from "./UserStory";
import ProgressBar from "./ProgressBar";
import Grid from "@mui/material/Grid";

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
        const favouriteStories = allStories.filter(s => s.favourite);

        const stories = props.detailedView ? allStories : favouriteStories;
        return (
            <div>
                <h2>
                    {project.name}
                </h2>
                <ProgressBar size={"large"}
                             percentage={Math.round(project.percentage * 100)}
                />
                <p>
                    <strong>Owner: </strong>
                    {project.owner.name}
                </p>
                <p>
                    <strong>Admins: </strong>
                    {project.admins.map(admin => <span key={admin.id}>{admin.name} </span>)}
                </p>
                <h3>User stories</h3>
                <Grid container spacing={{ xs: 2, md: 2 }} columns={{ xs: 1, sm: 1, md: 1 }}>
                    {stories.map(s =>
                        <Grid item xs={1} sm={1} md={1} key={s.id}>
                        <UserStory story={s}/>
                    </Grid>)}
                </Grid>
            </div>
        );
    }
}