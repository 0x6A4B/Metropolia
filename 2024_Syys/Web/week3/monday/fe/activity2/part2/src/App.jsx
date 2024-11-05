import { useState } from 'react'

import TourList from "./components/TourList";
import { tours } from "./assets/tours.json";
import './App.css'

function App() {
  const [t, delTour] = useState(0)

  const dell =  (t) =>  {
    tours.splice(tours.indexOf(tours.find(tt => tt.id === t)), 1);
    delTour(prev => {return {...prev}})
  }

  return (
    <>
      <main>
        <div>
        <div>
          <TourList tours={tours} del={dell} />
        </div>
        </div>
    </main>
    </>
  )

  
}


export default App
