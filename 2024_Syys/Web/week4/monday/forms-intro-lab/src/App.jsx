import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ContactUs from '../components/ContactUs'

function App() {
  const [count, setCount] = useState(0)

  return (
      <div>
        <ContactUs />
      </div>
  )
}

export default App
