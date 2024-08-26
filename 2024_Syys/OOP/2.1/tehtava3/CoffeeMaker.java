public class CoffeeMaker{
    Coffee coffee = Coffee.NORMAL; 
    int amount = 50, minAmount = 10, maxAmount = 80;
    boolean isOn = false;
   
    CoffeeMaker(){
    }

    void pressOnOff(){
        isOn = !isOn;
    }

    void pressSelection(){
        if (isOn)
            coffee = (coffee == Coffee.NORMAL) ? Coffee.ESPRESSO : Coffee.NORMAL;
    }

    String getSelection(){
        String selection = "";
        switch(coffee){
            case NORMAL:
                selection = isOn ? "Normal coffee" : "---";
                break;
            case ESPRESSO:
                selection = isOn ? "Espresso" : "---";
        }
        return selection;
    }

    void setAmount(int i){
        if (isOn && i <= maxAmount && i >= minAmount)
            amount = i;
    }

    int getAmount(){
        return amount;
    }

}

enum Coffee{
    NORMAL,
    ESPRESSO
}

/*
class Coffee{
    
}
*/
