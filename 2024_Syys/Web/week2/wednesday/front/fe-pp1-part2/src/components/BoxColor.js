export default function BoxColor(props) {
    const boxProps = props.boxProps;
    const pad = (i) => i.length > 1 ? i : "0" + i;
    const hexColour = "#" + pad(boxProps.r.toString(16)) + pad(boxProps.g.toString(16)) + pad(boxProps.b.toString(16));
    console.log("color: " + hexColour + " - ", boxProps)
  return (
    <div>
        <div style={{
            backgroundColor: hexColour,
            border: "2px solid",
            textAlign:"center",
            marginBottom: "20px",
            fontSize: "1.5em"
        }}>
            <p>rgb({boxProps.r + " " + boxProps.g + " " + boxProps.b})
            <br />{hexColour}</p>
        </div>
    </div>


  )
}
