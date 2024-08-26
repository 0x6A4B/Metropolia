import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class GroceryListManager{


    public static void main(String[] args){

        String[] items = { "Milk", "Milk", "Honey", "Cookies", "Tea", "Nuts & Bolts" };
        Double[] prices = { 1.0, 1.0, 2.5, 3.5, 2.0, 666.666 };

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

    private HashMap<String, Double> groceryList = new HashMap<>();

    public void addItem(String s, Double d){
        if (!checkItem(s) )
            groceryList.put(s, d);
    }

    public boolean removeItem(String item){
        return groceryList.remove(item) != null;
    }

    public void displayList(){
        int i = 1;
        Set<Map.Entry<String, Double>> set = groceryList.entrySet();

        for (Map.Entry<String, Double> e : set){
            System.out.println(i++ + ". " + e.getKey() + " - " + e.getValue() + "RMB");
        }

    }

    public boolean checkItem(String s){
        return groceryList.containsKey(s);
    }

    public double calculateTotalCost(){
        double totalCost = 0;
        Set<Map.Entry<String, Double>> set = groceryList.entrySet();

        for (Map.Entry<String, Double> e : set ){
            totalCost += e.getValue();
        }

        return totalCost;
    }

}
