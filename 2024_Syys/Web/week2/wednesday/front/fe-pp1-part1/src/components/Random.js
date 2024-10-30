export default function Random(props) {
    const rnd = (min, max) => {
        return Math.ceil(Math.random() * (max - min) + min)
    }
    return (
        <div className="idcard">
            <b>Random:</b> {rnd(props.min, props.max)}
        </div>
    )
}
