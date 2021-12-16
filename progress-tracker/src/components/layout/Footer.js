function Footer(props) {
    return (
        <div className="App-footer">
            <a className={"email"} href={"mailto:example@email.com"}>example@email.com</a>
            <p>{props.owner}</p>
            <p className="App-creators">
                Made by:
                {props.creators.map((creator, i) =>
                    <a href={props.links[i]} key={i} className="App-creator">
                        {creator}
                    </a>)}
            </p>
        </div>
    )
}

export default Footer;