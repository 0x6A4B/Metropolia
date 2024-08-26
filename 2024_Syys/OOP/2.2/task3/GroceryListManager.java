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
            list.addItem(items[i], prices[i]);
     
        System.out.println("Grocery list:");
        list.displayList();

        System.out.println("Is \"Milk\" in the grocery list? " + list.checkItem("Milk"));
        System.out.println("Removing \"Milk\" from the list...");
        System.out.println(list.removeItem("Milk") ? "Removed" : "No such thing");

        System.out.println("Updated grocerylist:");
        list.displayList();
        System.out.println("Total cost: " + list.calculateTotalCost() + "RMB");


    }

    private HashMap<Grocery, Double> groceryList = new HashMap<>();

    public void addItem(String s, Double d){
        if (!checkItem(s) )
            groceryList.put(new Grocery(s, "Uncategorized"), d);
    }
    
    public void addItem(String s, Double d, String c){
        if (!checkItem(s) )
            groceryList.put(new Grocery(s, c), d);
    }

    public boolean removeItem(String item){
        return groceryList.remove(item) != null;
    }

    public void displayList(){
        int i = 1;
        Set<Map.Entry<Grocery, Double>> set = groceryList.entrySet();

        for (Map.Entry<Grocery, Double> e : set){
            System.out.println(i++ + ". " + e.getKey().getName() + " - " 
                    + e.getValue() + "RMB");
        }

    }

    public void displayByCategory(String cat){
        int i = 1;
        Set<Map.Entry<Grocery, Double>> set = groceryList.entrySet();

        for (Map.Entry<Grocery, Double> e : set){
            if (e.getKey().getCategory() == cat)
                System.out.println(i++ + ". " + e.getKey().getName() + " - " 
                        + e.getValue() + "RMB");
        }
    }

    public boolean checkItem(String s){
        return groceryList.containsKey(s);
    }

    public double calculateTotalCost(){
        double totalCost = 0;
        Set<Map.Entry<Grocery, Double>> set = groceryList.entrySet();

        for (Map.Entry<Grocery, Double> e : set ){
            totalCost += e.getValue();
        }

        return totalCost;
    }

    class Grocery{
        String name;
        String category;

        Grocery(){}
        Grocery(String name, String cat){ this.name = name; category = cat; }

        public void setName(String s){ name = s;}
        public void setCategory(String s){ category = s; }
        public String getName() { return name; }
        public String getCategory() { return category; }

    }

}
