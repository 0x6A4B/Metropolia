export default function Random(props) {
    const rnd = (min, max) => {
        return Math.ceil(Math.random() * (max - min) + min)
    }

    return (
        <div className="randomclass">
            <p>Random value between {props.min} and {props.max} ={'>'} {rnd(props.min, props.max)}</p>
        </div>
    )
}
