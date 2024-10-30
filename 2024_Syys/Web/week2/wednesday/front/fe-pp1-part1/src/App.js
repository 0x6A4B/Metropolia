import './App.css';
import logo from './images/logo.svg';

import IdCard from './components/IdCard';
import Random from './components/Random';

const idCards  = [
  {
    lastName: 'Doe',
    firstName: 'John',
    gender: 'male',
    height: 178,
    birth: new Date("1992-07-14"),
    picture: "https://randomuser.me/api/portraits/men/44.jpg"
  },
  {
    lastName: 'Delores ',
    firstName: 'Obrien',
    gender: 'female',
    height: 172,
    birth: new Date("1988-05-11"),
    picture: "https://randomuser.me/api/portraits/women/44.jpg"
  }
]

const rands = [
  {
    min: 1,
    max: 10
  },
  {
    min: 1,
    max: 100
  }
]

let cardId=0;
let rndId=0;


function App() {
  return (
    <>
      <h3>React Practice</h3>
      <img src={logo} className="App-logo" alt="logo" />
      {
        idCards.map((value, index) => {
          return(
          <IdCard key={cardId++}
            lastName={value.lastName}
            firstName={value.firstName}
            gender={value.gender}
            height={value.height}
            birth={value.birth}
            picture={value.picture}
          />)
        })
      }
      <p>Random numbers:</p>
      {
        rands.map((value, index) => {
          return(
            <>
              <Random key={rndId++} min={value.min} max={value.max} />
              <br />
            </>
          )
        })
      }
    </>
  );
}

export default App;
