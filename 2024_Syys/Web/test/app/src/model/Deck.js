class Deck{
    constructor(){
        this.maxCards = 10;
        this.cards = [];
    }

    setCards(c){ this.cards = c; }
    addCard(c){ if (!this.full() && !this.cards.includes(c)) this.cards.push(c); }
    delCard(c){
        if (this.cards.indexOf(c) >= 0)
            this.cards.splice(this.cards.indexOf(c), 1);
    }
    getCard(i){ return this.cards[i]; }
    getCards(){ return this.cards; }
    length(){ return this.cards.length; }

    full(){ return this.cards.length >= this.maxCards; }

}

module.exports = Deck;