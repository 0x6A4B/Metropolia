import './App.css';

import A1Task2 from './activity1/Task2'
import A1Task3 from './activity1/Task3'
import A1Task4 from './activity1/Task4'

import A2Task1 from './activity2/Task1'
import A2Task2 from './activity2/Task2'
import A2Task3 from './activity2/Task3'






import { Routes, Route } from 'react-router-dom';
import NavBar from './components/NavBar';

function App() {
  return (
    <>
    <h1>Monday's activities with one react server and node_modules</h1>
      
      <div>
      <NavBar />
      </div>
      <div className='content'>
      <Routes>
        
        <Route path="/A1TASK2" element={<A1Task2 />} />
        <Route path="/A1TASK3" element={<A1Task3 />} />
        <Route path="/A1TASK4" element={<A1Task4 data={[{data:"data passed through", otherData:"otherData"},{data:"data2", otherData:"otherData2"}]}/>} />

        <Route path="/A2TASK1" element={<A2Task1 data={[{data:"data passed through", otherData:"otherData"},{data:"data2", otherData:"otherData2"}]}/>} />
        <Route path="/A2TASK2" element={<A2Task2 />} />
        <Route path="/A2TASK3" element={<A2Task3 />} />




      </Routes>
      </div>
      </>

  );
}


export default App;
