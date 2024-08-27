public class CoffeeMaker{
    Coffee coffee = Coffee.NORMAL; 
    int amount = 50, minAmount = 10, maxAmount = 80;
    boolean isOn = false;
   
    public CoffeeMaker(){}

    public boolean isOn(){ return isOn; }

    public void pressOnOff(){ isOn = !isOn; }

    public void pressSelection(){
        if (isOn)
            coffee = (coffee == Coffee.NORMAL) ? Coffee.ESPRESSO : Coffee.NORMAL;
    }

    public String getSelectionString(){
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

    public Coffee getSelection(){ return coffee; }

    public void setAmount(int i){
        if (isOn && i <= maxAmount && i >= minAmount)
            amount = i;
    }

    public int getAmount(){
        return amount;
    }

}

