const Card = require ('../model/Card');
const Pack = require ('../model/Pack');
const Deck = require ('../model/Deck');



// test cards
const cards = [
    new Card(0, "jaakko", 0),
    new Card(1, "niilo", 1),
    new Card(2, "olavi", 2),
    new Card(3, "yrjö", 3),
    new Card(4, "toivo", 4),
]

cards.forEach(c => console.log(c));


async function testWithWait(){


    // test pack
    console.log("TEST PACK:\n\n\n");
    let pack = new Pack();
    await pack.generateCards();

    await pack.getPack().cards.forEach(c => console.log(c));


    // test deck
    console.log("TEST DECK:\n\n\n");
    let deck = new Deck();

    deck.addCard(cards[0]);

    //deck.setCards(pack.getPack().cards);

    deck.addCard(cards[1]);

    console.log(deck.getCard(0).name)
    deck.delCard(deck.getCard(0));

    deck.getCards().forEach(c => console.log(c));

    console.log(deck.length())

}

async function test(){ await testWithWait();}

test();

// test ollama query

const ollama = require('../modules/ollamaFetch.js');
async function query(){
    let s = await ollama.queryOllama("reptilian overlord");
    console.log(s);
    return s;
}
query();

console.log(ollama.queryOllama("orc"));

