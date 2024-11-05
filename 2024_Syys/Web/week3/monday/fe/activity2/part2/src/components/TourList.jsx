// src/TourList.jsx
import Tour from "./Tour";

const TourList = (props) => {
  const { tours } = props;

  return (
    <section>
      <div className="title">
        <h2>our tours</h2>
        <div className="underline"></div>
      </div>
      <div>
        { tours.map(t => {
            //console.log(t);
            
                return <Tour key={t.id} tour={t} del={props.del} />
            })
        }
      </div>
    </section>
  );
};

export default TourList;