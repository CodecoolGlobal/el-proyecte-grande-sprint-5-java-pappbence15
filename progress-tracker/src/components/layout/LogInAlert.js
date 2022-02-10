import {Alert, AlertTitle, Stack} from "@mui/material";
import Link from "@mui/material/Link";


export default function DescriptionAlert() {
    return (
    <Stack sx={{ width: '100%' }} spacing={2} style={{marginTop: '5%'}}>
        <Alert severity="error">
            <AlertTitle>Error</AlertTitle>
            You are not logged in.<strong> Log in or register!  </strong>
            <Link href={"http://localhost:8080/greeting"} underline={'hover'} color={'error'}>{"Here"}</Link>
        </Alert>
        </Stack>
    );
    }
