import { NavLink } from "react-router-dom";

export default function NavBar(){
    return(
      <nav>
        <div className="nav">
            <ul>
            <li><NavLink to="/A1TASK2">Activity 1 - Task 2/4</NavLink></li>
            <li><NavLink to="/A1TASK3">Activity 1 - Task 3/4</NavLink></li>
            <li><NavLink to="/A1TASK4">Activity 1 - Task 4/4</NavLink></li>
            <br></br>
            <li><NavLink to="/A2TASK1">Activity 2 - Task 1/3</NavLink></li>
            <li><NavLink to="/A2TASK2">Activity 2 - Task 2/3</NavLink></li>
            <li><NavLink to="/A2TASK3">Activity 2 - Task 3/3</NavLink></li>

            </ul>
        </div>
      </nav>
      
    )
}