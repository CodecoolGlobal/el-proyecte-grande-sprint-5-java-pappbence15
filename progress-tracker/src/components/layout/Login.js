import {useState} from "react";


export default function Login(props){
    const [username, setUserName] = useState();
    const [password, setPassword] = useState();

    const handleSubmit = async e => {
        e.preventDefault();
        const token = await loginUser({
            username,
            password
        });
        props.setToken(token);
    }

    return(
        <div>
            <form action="/login" onSubmit={handleSubmit}>
                <label htmlFor="user-name">User name</label>
                <input type="text" id="user-name" onChange={e => setUserName(e.target.value)}/>
                <label htmlFor="password">Password</label>
                <input type="password" id="password" onChange={e => setPassword(e.target.value)}/>
                <button type="submit" onSubmit={props.setToken()}>Login</button>
            </form>
        </div>
    )
}

async function loginUser(credentials){
    return fetch("/login", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(credentials)
    })
        .then(data => data.json())
}