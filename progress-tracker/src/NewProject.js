import {Grid} from "@mui/material";

function NewProject(props) {
    return(
        <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
            <Grid item xs={6} direction={"row"}>
                <input type={"text"}>Project name</input>
                <input type={"email"}>Owner's email</input>
                <input type={"email"}>Admin's email</input>
            </Grid>
        </Grid>
    )
}

export default NewProject;