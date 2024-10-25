const Card = require('./Card');

class Pack{

    async generateCards(){
        let cards = [];
        for(let i = 0; i < 10; i++){
            let faction = this.getRandomFaction();
            let factionStr = Card.getFactionString(faction);
            await cards.push(new Card(this.getRandomRarity(), await this.getRandomName(factionStr)
                    , faction));
        }
        this.cards = cards;
    }

    getPack(){ return this; }

    getCard(i){ return this.cards[i]; }

    async getRandomName(faction){
        if (faction != null)
            return await this.queryName(faction);

        const names = [
            "Evelyn",
            "Kaius",
            "Aurora",
            "Finnley",
            "Sage",
            "Remington",
            "Luna",
            "Caspian",
            "Indigo",
            "Willow"
          ];

        return names[Math.floor(Math.random() * 10)];
    }

    ollama = require('../modules/ollamaFetch.js');
    async queryName(faction){
        return await this.ollama.queryOllama(faction);
    }

    /*
     * Doesn't have any probability for different rarities
     */
    getRandomRarity(){
        return Math.floor(Math.random() * 5);
    }

    getRandomFaction(){
        return Math.floor(Math.random() * 7);
    }
}

module.exports = Pack;