import './UseState.css';
import { useState } from 'react';


const UseState = () => {
  const [theme, setTheme] = useState('light');
  const [clickNr, setClick] = useState(0);

/*  const click = (choice) => {
    console.log(choice);
    setTheme(choice);
  }
*/

  const count = (event) =>{
    let btn = event.target.textContent;
    console.log(btn, clickNr)
    switch(btn){
      case "Increment":
        setClick(prevCount => prevCount + 1);
        break;
      case "Decrement":
        setClick(prevCount => prevCount - 1);
    }
  }
  const toggle = () => {
    console.log("Toggle, current state:", theme);
    switch(theme){
      case "light":
        setTheme('dark');
        break;
      default:
        setTheme('light');
    }
    
  }

  return (
    <div className={`state ${theme}`}>
      <h1>UseState Component</h1>
      <button onClick={() => setTheme('dark')}>Dark</button>
      <button onClick={() => setTheme('light')}>Light</button>
      <button onClick={toggle}>Toggle Theme</button>
      <h2>Clicked {clickNr} times</h2>
      <button onClick={(e) => count(e)}>
        Increment
      </button>
      <button onClick={count}>
        Decrement
      </button>
    </div>
  );
};

export default UseState;
