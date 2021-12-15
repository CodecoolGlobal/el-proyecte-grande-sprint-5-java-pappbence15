import {useEffect, useState} from "react";
import UserStory from "./UserStory";

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
                    console.log(result)
                    console.log(project)
                },
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            )
    }, [])


    if (error) {
        return <div>Error: {error.message}</div>;
    } else if (!isLoaded) {
        return <div>Loading...</div>;
    } else {
        const allStories = project.userStories;
        const favouriteStories = allStories.filter(s=>s.isFavourite);

        const stories = props.detailedView ? allStories : favouriteStories;
        return (
            <div>
                <p>
                    {project.name}
                </p>
                <p>
                    {project.id}
                </p>
                <div>
                    {stories.map(s=><UserStory story={s}/>)}
                </div>
            </div>
        );
    }
}