public class Test{

    public static void main(String[] args){

        CoffeeMaker tervaMylly = new CoffeeMaker();


        for (int i = 0; i < 5; i++){
            System.out.println("Coffeemaker is " + ((tervaMylly.isOn) ? " ON" : " OFF"));
        

            tervaMylly.pressSelection();  // if coffeemaker is OFF this shouldn't work

            if(!tervaMylly.isOn()){
                System.out.println("Starting coffeemaker");
                tervaMylly.pressOnOff();
            }
            
            System.out.println("Coffee set to " + tervaMylly.getSelectionString() 
                    + ". Switching to " + ((tervaMylly.getSelection() == Coffee.NORMAL) ? "Espresso" : "Normal")
                    );
            tervaMylly.pressSelection();

            tervaMylly.pressOnOff();
        }

    }


}
