import './App.css';
import logo from './images/logo.svg';
import CreditCard from './components/CreditCard';
import BoxColor from './components/BoxColor';

const creditcards = [
  {
    type: "Visa",
    number: "0123456789018845",
    expirationMonth: 3,
    expirationYear: 2021,
    bank: "BNP",
    owner: "Maxence Bouret",
    bgColor: "#11aa99",
    color: "white" 
  },
  {
    type: "MasterCard",
    number: "0123456789010995",
    expirationMonth: 3,
    expirationYear: 2021,
    bank: "N26",
    owner: "Maxence Bouret",
    bgColor: "#eeeeee",
    color: "#222222",
  },
  {
    type: "Visa",
    number: "0123456789016984",
    expirationMonth: 12,
    expirationYear: 2019,
    bank: "Name of the Bank",
    owner: "Firstname Lastname",
    bgColor: "#ddbb55",
    color: "white"
  }
]

const boxes = [
  {
    r: 255, g: 0, b:0
  },
  {
    r: 128, g: 255, b:0
  }
]

function App() {
  let ccKey = 0;
  let boxKey = 0;

  return (
    <>
      <h3>Credit cards</h3>
      <div className="allcards">
        {
          creditcards.map((value, index) => {
            return <CreditCard key={ccKey++} ccProps={creditcards[index]} />
          })
        }
      </div>
      <div className="boxcolor">
        {
          boxes.map((value, index) => 
            <BoxColor key={boxKey++} boxProps={boxes[index]} />
          )
        }
      </div>
    </>
  );
}

export default App;
