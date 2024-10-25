/*
 *
 * rarityLevel 0..4
 * name String
 * faction 0..6
 */
class Card{
    static id = 0;
    constructor(rarityLevel, name, faction){
        this.id = Card.id++;

        this.rarityLevel = rarityLevel;
        this.name = name;
        
        this.faction = factionString(faction);
        this.color = colorString(rarityLevel);
        this.rarity = rarityString(rarityLevel);

        this.generateCard();
    }

    /*
     *
     * attack
     * defense
     * movement
     * range
     */
    generateCard(){
        let minAttack, maxAttack;
        let minDefense, maxDefense;
        let minMovement, maxMovement;
        let range;

        minAttack = (this.rarityLevel + 1) * 10;
        maxAttack = (this.rarityLevel + 1) * 100;
        minDefense = (this.rarityLevel + 1) * 10;
        maxDefense = (this.rarityLevel + 1) * 100;
        minMovement = (this.rarityLevel + 1) * 10;
        maxMovement = (this.rarityLevel + 1) * 100;
        range = 0;

        this.attack = random(minAttack, maxAttack);
        this.defense = random(minDefense, maxDefense);
        this.movement = random(minMovement, maxMovement);
        this.range = range;

/*        switch(this.rarityLevel){
            default:
            case 0:
                min
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
                */
    }


    static getFactionString(i){ return factionString(i); }    
}

module.exports = Card;

const random = (min, max) => Math.floor(Math.random() * (max - min) + min);

const factionString = (i) => {
    let factionArr = [
        "Humans",
        "Elves",
        "Dwarves",
        "Reptilian Overlords",
        "Orcs",
        "Goblins",
        "Politicians"
    ];
    
    return factionArr[i];
};

const colorString = (i) => {
    let colorArr = [
        "white",
        "green",
        "blue",
        "purple",
        "gold"
    ];

    return colorArr[i];
};

const rarityString = (i) => {
    let rarityArr = [
        'Common', 
        'Uncommon', 
        'Rare', 
        'Legendary', 
        'Mythic'
    ];
    return rarityArr[i];
};

/*
const Rarity__   =  { 
    1: 'Common', 
    2: 'Uncommon', 
    3: 'Rare', 
    4: 'Legendary', 
    5: 'Mythic'
};

const Rarity_  = {
    Common: 1,
    Uncommon: 2,
    Rare: 3,
    Legendary: 4,
    Mythic: 5
  };
  */