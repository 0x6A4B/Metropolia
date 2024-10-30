export default function IdCard(props){
    return(
        <>
            <div className="idcard">
                <img alt="pic" src={props.picture} />
                <div className="idtext">
                    <p><b>First name:</b> {props.firstName}</p>
                    <p><b>Last name:</b> {props.lastName}</p>
                    <p><b>Gender:</b> {props.gender}</p>
                    <p><b>Height</b> {props.height}</p>
                    <p><b>Birth:</b> {props.birth.toDateString()}</p>
                </div>
            </div>
        </>
    )
}