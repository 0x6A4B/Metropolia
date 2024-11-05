import { useState } from 'react'
import './App.css'

import Book from './components/Book'
import './components/book.css'
import bookJson from './assets/books.json'
import { OverloadTest } from './components/OverloadTest'

//const books = require('assets/books.json')
const books = bookJson.books
console.log("start: ", books);

function App() {
const [bb, setBooks] = useState({})


/* NO OVERLOAS IN JS :( */
/*
const oltest = new OverloadTest();
oltest.name()
oltest.name(5)

overLoad();
overLoad(1);
*/
/**/

  return (
    <>
      <div>
        <ul>
          { books.map(b => <Book clk={click} key={b.id} book={b} />) }
        </ul>
      </div>
        
    </>
  )

  function click(bok){
    
    // books is a constant.. as it should be as an array?
    //books = books.filter(b => b.id !== bok.id);
    console.log(books.filter(b => b.id === bok.id)[0]);
    books.splice(books.indexOf(books.find(b => b.id === bok.id), 1));
    
    setBooks(prev => {
      return { ...prev}
    })
  }

  function overLoad() {console.log("A");}
  function overLoad(B) {console.log("B");}


  

  
}

export default App
