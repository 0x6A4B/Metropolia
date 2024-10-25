import logo from './logo.svg';
import './App.css';

import { useState, setState, useEffect } from 'react';

const Pack = require('./model/Pack');
const Deck = require('./model/Deck');

const deckC = new Deck();

function App() {
  const [cards, setCards] = useState([]);
  const [deck, setDeck] = useState([]);

  
  useEffect(() => {
    console.log("Deck:")
    console.log(deck)
  }, [deck]);

  useEffect(() => {
    console.log("Cards:")
    console.log(cards)
  }, [cards]);

  return (
    <div className="App">
      <header className="App-header">
      {/*
      <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
          IT WORKS!!!!
        </p>
        
        */}
        <p>Cards owned</p>
        <table>
        <tbody>
          <tr>
            <th>Name</th>
            <th>Faction</th>
            <th>Rarity</th>
            <th>Attack</th>
            <th>Defense</th>
            <th>Movement</th>
          </tr>

          {
            cards.map((card) => {
              return (
                <tr key={card.id} onClick={() => addToDeck(card.id)}>
                  <td>{card.name}</td>
                  <td>{card.faction}</td>
                  <td>{card.rarity}</td>
                  <td>{card.attack}</td>
                  <td>{card.defense}</td>
                  <td>{card.movement}</td>
                </tr>
              );
            })
          }
            
        </tbody></table>

        Deck
        <table><tbody>
          <tr>
            <th>Name</th>
            <th>Faction</th>
            <th>Rarity</th>
            <th>Attack</th>
            <th>Defense</th>
            <th>Movement</th>
          </tr>

          {
            deck.map((card) => {
              return (
                <tr key={card.id} onClick={() => removeFromDeck(card.id)}>
                  <td>{card.name}</td>
                  <td>{card.faction}</td>
                  <td>{card.rarity}</td>
                  <td>{card.attack}</td>
                  <td>{card.defense}</td>
                  <td>{card.movement}</td>
                </tr>
              );
            })
          }

        </tbody></table>
        <button onClick={getPack}>Get a Pack</button>
      </header>
    </div>
  );

  async function getPack(){
    let pack = new Pack();
    await pack.generateCards();
    await setCards(prevCards => ([...prevCards, ...pack.getPack().cards]));
  }

  function addToDeck(i){
    console.log("Clicked: " + i + " deck size: " + deck.length);
    //if (deck.length < 10 && !deck.includes(cards[i]))
    //  setDeck(prevDeck => ([...prevDeck, cards[i]]));

    console.log("Card:"); console.log(cards[i]);
    deckC.addCard(cards[i]);
    // miksi?
    setDeck([...deckC.getCards()]);

  }

  function removeFromDeck(i){
    console.log("Remove: " + i + " - " + deck.filter(c => c.id === i)[0]);
    /*const _deck = deck.filter(c => c.id !== i);
    console.log(_deck)
    setDeck(_deck);
    */
//   console.log(deckC.getCards());
//   console.log(deck.filter(c => c.id === i)[0])
//   console.log(deck.length)
   deckC.delCard(deck.filter(c => c.id === i)[0]);
   
   // miksi tämä rekisteröityy?
   setDeck([...deckC.getCards()]);
  }

  
}





export default App;
