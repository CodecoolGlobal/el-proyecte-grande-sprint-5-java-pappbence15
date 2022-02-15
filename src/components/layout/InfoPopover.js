import * as React from 'react';
import Popover from '@mui/material/Popover';
import Typography from '@mui/material/Typography';
import InfoIcon from "@mui/icons-material/Info";
import {Fab} from "@mui/material";

export default function BasicPopover(props) {
    const [anchorEl, setAnchorEl] = React.useState(null);

    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };

    const open = Boolean(anchorEl);
    const id = open ? 'simple-popover' : undefined;

    return (
        <div>
            <Fab size={"small"} onClick={handleClick}>
                <InfoIcon/>
            </Fab>
            <Popover
                id={id}
                open={open}
                anchorEl={anchorEl}
                onClose={handleClose}
                anchorOrigin={{
                    vertical: 'bottom',
                    horizontal: 'left',
                }}
            >
                <Typography sx={{ p: 2 }}>Owner: {props.owner}</Typography>
                <Typography sx={{ p: 2 }}>Admins: {props.admins.map(admin =>
                admin.name + " "
                )}</Typography>
            </Popover>
        </div>
    );
}