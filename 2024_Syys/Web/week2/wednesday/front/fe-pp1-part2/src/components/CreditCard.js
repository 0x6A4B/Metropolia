export default function CreditCard(props) {
    let ccProps = props.ccProps;



    const cardNumber = (ccNum) => {
        let pos = 0;
        return [...ccNum.substr(0,12)]
            .map(c => 
                c.replace(/\d/, 
                pos++ % 4 === 0 ? " •" : "•")
            )
            .join("")
            + " " + ccNum.substr(12, 4);
    }


    return (
        <>
            <div className="creditcard"
                style={{
                    backgroundColor: ccProps.bgColor,
                    color: ccProps.color
                    }}>
                <img align="right" alt={ccProps.type.toLowerCase()} src={"./" + ccProps.type.toLowerCase() + ".svg"} />
                <p className="number">{cardNumber(ccProps.number)}</p>
                <p>Expires {ccProps.expirationMonth}/{ccProps.expirationYear}
                <span className="bank">{ccProps.bank}</span></p>
                <p>{ccProps.owner}</p>
            </div>

        </>
  )
}
