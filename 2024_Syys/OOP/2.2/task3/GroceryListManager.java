import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class GroceryListManager{


    public static void main(String[] args){

        String[] items = { "Milk", "Milk", "Honey", "Cookies", "Tea", "Nuts & Bolts" };
        Double[] prices = { 1.0, 1.0, 2.5, 3.5, 2.0, 666.666 };
        String[] category = { "Drink", "Drink", "Sweetener", "Sweets", "Drink", "Whatta hell?" };

        GroceryListManager list = new GroceryListManager();



        for (int i = 0; i < items.length; i++)            
            list.addItem(items[i], prices[i], category[i]);
     
        System.out.println("Grocery list:");
        list.displayList();

        System.out.println("Is \"Milk\" in the grocery list? " + list.checkItem("Milk"));
        System.out.println("Removing \"Milk\" from the list...");
        System.out.println(list.removeItem("Milk") ? "Removed" : "No such thing");

        System.out.println("Updated grocerylist:");
        list.displayList();
        System.out.println("Total cost: " + list.calculateTotalCost() + "RMB");

        System.out.println("Display by category drink");
        list.displayByCategory("dRiNk");

    }

    private HashMap<String, Grocery> groceryList = new HashMap<>();

    public void addItem(String s, Double d){
        if (!checkItem(s) )
            groceryList.put(s, new Grocery(s, "Uncategorized", d));
    }
    
    public void addItem(String s, Double d, String c){
        if (!checkItem(s) )
            groceryList.put(s, new Grocery(s, c, d));
    }

    public boolean removeItem(String item){
        return groceryList.remove(item) != null;
    }

    public void displayList(){
        int i = 1;
        Set<Map.Entry<String, Grocery>> set = groceryList.entrySet();

        for (Map.Entry<String, Grocery> e : set){
            System.out.println(i++ + ". " + e.getKey() + " - " 
                    + e.getValue().getPrice() + "RMB"
                    + " (" + e.getValue().getCategory() + ")");
        }

    }

    public void displayByCategory(String cat){
        int i = 1;
        Set<Map.Entry<String, Grocery>> set = groceryList.entrySet();

        for (Map.Entry<String, Grocery> e : set){
            if (e.getValue().getCategory().toLowerCase().equals(cat.toLowerCase()))
                System.out.println(i++ + ". " + e.getValue().getName() + " - " 
                        + e.getValue().getPrice() + "RMB");
        }
    }

    public boolean checkItem(String s){
        return groceryList.containsKey(s);
    }

    public double calculateTotalCost(){
        double totalCost = 0;
        Set<Map.Entry<String, Grocery>> set = groceryList.entrySet();

        for (Map.Entry<String, Grocery> e : set ){
            totalCost += e.getValue().getPrice();
        }

        return totalCost;
    }

    class Grocery{
        String name;
        String category;
        double price;

//        Grocery(){}
        Grocery(String name, String cat, double price){
            this.name = name; category = cat; this.price = price;
        }

        public void setName(String s){ name = s;}
        public void setCategory(String s){ category = s; }
        public String getName(){ return name; }
        public String getCategory(){ return category; }
        public double getPrice(){ return price; }

    }

}
