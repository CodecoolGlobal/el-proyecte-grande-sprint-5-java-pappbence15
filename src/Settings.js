import Grid from '@mui/material/Grid';
import {Box, Switch} from "@mui/material";
const {useState, useEffect} = require("react");

function Settings(props){
    const [notifications, setNotifications] = useState(false);
    const [isLoaded, setIsLoaded] = useState(false);
    const [error, setError] = useState(null);

    useEffect(()=>{
        fetch("/settings")
            .then(res => res.json())
            .then(
                (result) => {
                    setNotifications(result.notifications);
                    setIsLoaded(true);
                },(error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            )
    }, [])

    if(error){
        return(<div className='error-message'>
            {error.message}
        </div>)
    }else if (!isLoaded){
        return(
            <div className='loading-container'>
                Loading...
            </div>
        )
    }else{
        return(
            <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
                <Grid item xs={6} direction={"row"}>
                    <p>Notifications</p>
                </Grid>
                <Grid item xs={6} direction={"row"}>
                    <Switch
                        size={"large"}
                        checked={notifications}
                        onChange={handleNotificationClick}
                        inputProps={{ 'aria-label': 'controlled' }}
                    />
                </Grid>
                <Grid item xs={6}>
                    <p>Dark mode</p>
                </Grid>
                <Grid item xs={6}>
                    <Switch
                        size={"large"}
                        checked={props.darkMode}
                        onChange={handleDarkModeClick}
                        inputProps={{ 'aria-label': 'controlled' }}
                    />
                </Grid>
            </Grid>
        )
    }

    function handleNotificationClick(){
        const url = `/settings/update/notifications/${!notifications}`;
        fetch(url, {method: "POST"});
        setNotifications(!notifications);
    }

    function handleDarkModeClick() {
        const url = `/settings/update/darkMode/${!props.darkMode}`;
        fetch(url, {method: "POST"}).then(() => props.setTheme(!props.darkMode));

    }
}



export default Settings;