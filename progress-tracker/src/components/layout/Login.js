import {useState} from "react";


export default function Login(props){
    const [username, setUserName] = useState();
    const [password, setPassword] = useState();

    const handleSubmit = (e) => {
        e.preventDefault();
        const token = new FormData()
        token.append("username", username)
        token.append("password", password)
        props.setToken(token);
        fetch("http://localhost:8080/login", {
            method: 'POST',
            body: token,
            mode: "no-cors"
        }).then()
    }

    return(
        <div>
            <form encType={"multipart/form-data"} onSubmit={handleSubmit}>
                <label htmlFor="user-name">User name</label>
                <input type="text" id="user-name" onChange={e => setUserName(e.target.value)}/>
                <label htmlFor="password">Password</label>
                <input type="password" id="password" onChange={e => setPassword(e.target.value)}/>
                <button type="submit" onSubmit={props.setToken()}>Login</button>
            </form>
        </div>
    )
}

// async function loginUser(credentials){
//     return fetch("/login", {
//         method: 'POST',
//         body: credentials
//     })
//         .then(data => data.json())
// }