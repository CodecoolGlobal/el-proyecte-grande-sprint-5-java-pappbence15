import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import TemporaryDrawer from "./Drawer";

export default function ResponsiveAppBar(props) {
    return (
        <Box sx={{ flexGrow: 1 }}>
            <AppBar position="static" enableColorOnDark>
                <Toolbar>
                    <img src="https://i.imgur.com/eB4sG1t.png" alt="logo" className={'App-logo'}/>
                    <TemporaryDrawer changeComponent={props.changeComponent}/>
                    <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
                        GET IT DONE
                    </Typography>
                </Toolbar>
            </AppBar>
        </Box>
    );
}
