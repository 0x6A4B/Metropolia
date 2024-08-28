import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class GroceryListManager{


    public static void main(String[] args){

        String[] items = { "Milk", "Milk", "Honey", "Cookies", "Tea", "Nuts & Bolts" };
        Double[] prices = { 1.0, 1.0, 2.5, 3.5, 2.0, 666.666 };
        String[] category = { "Drink", "Drink", "Sweetener", "Sweets", "Drink", "Whatta hell?" };
        int[] qty = { 1, 1, 2, 3, 4, 0 };

        GroceryListManager list = new GroceryListManager();



        for (int i = 0; i < items.length; i++)            
            list.addItem(items[i], prices[i], category[i], qty[i]);
     
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

        System.out.println("Available items:");
        list.displayAvailableItems();
        System.out.println("Qty of milk modified: " 
                + ((list.updateQuantity("MiLk", 1984)) ? "success" : "miserable failure"));
        System.out.println("Qty of tea modified: " 
                + ((list.updateQuantity("tEa", 0)) ? "success" : "miserable failure"));
//        list.updateQuantity("tEa", 0);
        System.out.println("Available items now:");
        list.displayAvailableItems();

    }

    private HashMap<String, Grocery> groceryList = new HashMap<>();

    public void addItem(String s, Double d){ addItem(s, d, "Uncategorized"); }
    public void addItem(String s, Double d, String c){ addItem(s, d, c, 1); }
    public void addItem(String s, Double d, String c, int q){
        if (!checkItem(s) )
            groceryList.put(s.toLowerCase(), new Grocery(s, c, d, q));
        else
            groceryList.get(s.toLowerCase()).setQuantity(
                    groceryList.get(s.toLowerCase()).getQuantity()+q);
    }

    public boolean removeItem(String item){
        return groceryList.remove(item.toLowerCase()) != null;
    }

    public void displayList(){
        int i = 1;
        Set<Map.Entry<String, Grocery>> set = groceryList.entrySet();

        for (Map.Entry<String, Grocery> e : set){
            System.out.println(i++ + ". " + e.getValue().getName() + " - " 
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
        return groceryList.containsKey(s.toLowerCase());
    }

    public double calculateTotalCost(){
        double totalCost = 0;
        Set<Map.Entry<String, Grocery>> set = groceryList.entrySet();

        for (Map.Entry<String, Grocery> e : set ){
            totalCost += e.getValue().getPrice();
        }

        return totalCost;
    }


    public boolean updateQuantity(String item, int newQuantity){
        if (checkItem(item.toLowerCase()))
            groceryList.get(item.toLowerCase()).setQuantity(newQuantity);
        return checkItem(item.toLowerCase());
    }

    public void displayAvailableItems(){
        int i = 0;
        Set<Map.Entry<String, Grocery>> set = groceryList.entrySet();

        for (Map.Entry<String, Grocery> e : set)
            if(e.getValue().getQuantity() > 0)
                System.out.println(++i + ". " + e.getValue().getName() + " - "
                        + e.getValue().getQuantity());
    }
    




    // Grocery Item. An item in the shopping list. Would be made of a Product class
    // product class would be the actual product that is taken by the Grocery item
    // Grocery item would have the amount of units and product item the single products
    // prices etc.
    // But that won't be necessary in this case as string is enough
    class Grocery{
        String name;
        String category;
        double price;
        int quantity;

//        Grocery(){}
        Grocery(String name, String cat, double price){
            this.name = name; category = cat; this.price = price;
        }
        
        Grocery(String name, String cat, double price, int qty){
            this.name = name; category = cat; this.price = price; quantity = qty;
        }


        public void setName(String s){ name = s; }
        public void setCategory(String s){ category = s; }
        public String getName(){ return name; }
        public String getCategory(){ return category; }
        public double getPrice(){ return price; }
        public void setQuantity(int qty) { quantity = qty; }
        public int getQuantity(){ return quantity; }

    }

}
