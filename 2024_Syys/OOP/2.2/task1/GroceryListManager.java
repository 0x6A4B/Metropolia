import java.util.ArrayList;

public class GroceryListManager{


    public static void main(String[] args){

        String[] items = { "Milk", "Milk", "Honey", "Cookies", "Tea", "Nuts & Bolts" };

        GroceryListManager list = new GroceryListManager();

        for (int i = 0; i < items.length; i++)            
            list.addItem(items[i]);
     
        System.out.println("Grocery list:");
        list.displayList();

        System.out.println("Is \"Milk\" in the grocery list? " + list.checkItem("Milk"));
        System.out.println("Removing \"Milk\" from the list...");
        System.out.println(list.removeItem("Milk"));

        System.out.println("Updated grocerylist:");
        list.displayList();

        System.out.println("Is \"Milk\" in the grocery list? " + list.checkItem("Milk"));


    }

    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String s){
        if (!checkItem(s) )
            groceryList.add(s);
    }

    public boolean removeItem(String item){
        return groceryList.remove(item);
    }

    public void displayList(){
        for (int i = 0; i < groceryList.size(); i++){
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }

    public boolean checkItem(String s){
        return groceryList.contains(s);
    }


}
