import Greeting from "./t3Components/Greetings";

import './t3_style.css';

export default function Task2(){
    return(
        <div>
            <Greeting name="Alice" message="Welcome to the lab!" />
            <Greeting name="Bob" message="Good morning" />
        </div>
    )
}