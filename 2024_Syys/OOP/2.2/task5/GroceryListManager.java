import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.ArrayList;

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


        // Shopping lists
        // this is gonna be case sensitive, not gonna do that extra work
        System.out.println("\n\n\nSHOPPING LIST, BABy!!");

        list.createShoppingList("Tea Party", list.addItem("Tea", 1.5, "Drink", 2));
        System.out.println("Item added: "
                + list.addItemToList("Tea Party", list.addItem("Cookie", 2.5, "Sweets", 4)));

        list.createShoppingList("Beer Party", list.addItem("Beer", 1.5, "Drink", 2));
        System.out.println("Item added: "
            + list.addItemToList("Beer Party", list.addItem("More Beer", 3.0, "Drink", 4)));
        System.out.println("Item added: "
            + list.addItemToList("Beer Party", list.addItem("Cookie", 2.5, "Sweets", 4)));

        //list.displayShoppingList("Tea Party");
        //list.displayShoppingList("Beer Party");
        list.displayShoppingList();

        // no cookies to beer party
        System.out.println("Item removed: "
            + list.removeItemFromList("Beer Party", "Cookie"));

        System.out.println("\n\nNO COOKIES!! BEER ONLY!!");
        list.displayShoppingList();

    }

    private HashMap<String, Grocery> groceryList = new HashMap<>();

    public void addItem(String s, Double d){ addItem(s, d, "Uncategorized"); }
    public void addItem(String s, Double d, String c){ addItem(s, d, c, 1); }
    public Grocery addItem(String s, Double d, String c, int q){
        if (!checkItem(s) )
            groceryList.put(s.toLowerCase(), new Grocery(s, c, d, q));
        else
            groceryList.get(s.toLowerCase()).setQuantity(
                    groceryList.get(s.toLowerCase()).getQuantity()+q);
        return groceryList.get(s.toLowerCase());
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
    

    // shopping lists
    ArrayList<ShoppingList> shoppingLists = new ArrayList<>();

    public void createShoppingList(String s){ shoppingLists.add(new ShoppingList(s)); }
    public void createShoppingList(String s, Grocery g){
        shoppingLists.add(new ShoppingList(s, g));
    }

    public boolean addItemToList(String s, Grocery g){
        for(ShoppingList sl : shoppingLists)
            if(sl.getName().equals(s))
                return sl.addItem(g);
        return false;
    }

    // not gonna implement returning of Grocery object to be able to use this
    // just gonna leave this as a TODO
    public boolean removeItemFromList(String s, Grocery g){
        for(ShoppingList sl : shoppingLists)
            if(sl.getName().equals(sl))
                return sl.removeItem(g);
        return false;
    }

    public boolean removeItemFromList(String s, String i){
        for(ShoppingList sl : shoppingLists)
            if(sl.getName().equals(s))
                return sl.removeItem(i);
        return false;
    }

    public void displayShoppingList(){
        for (ShoppingList sl : shoppingLists)
            sl.displayShoppingList();
    }

    // TODO implementation
    // not gonna happen
    public void displayShoppingList(String s){
        for (ShoppingList sl : shoppingLists)
            sl.displayShoppingList();
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


    class ShoppingList{

        private String name;
//        HashMap<String, Grocery> groceries;
        private ArrayList<Grocery> groceries = new ArrayList<>();

        ShoppingList(String name, Grocery g){ this(name); addItem(g); }
        ShoppingList(String name){ this.name = name; }

        public String getName(){ return name; }
        
        public boolean addItem(Grocery g){
            return groceries.add(g);
//            return false;
        }

        public boolean removeItem(String s){
            //return removeItem(groceries.get(s.toLowerCase()));
            for (Grocery g : groceries)
                if (g.getName().equals(s))
                    return removeItem(g);
            return false;
        }

        public boolean removeItem(Grocery g){
            return groceries.remove(g);
        }

        public ArrayList<Grocery> getShoppingList(){ return groceries; }

        public void displayShoppingList(){
            System.out.println("Shoppinglist " + name + ":");
            for (Grocery g : groceries)
                System.out.println(g.getName() + " - " + g.getQuantity() + " units");
        }

    }

}
