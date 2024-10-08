import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ShoppingCart {
    private ArrayList<ShoppingItem> items;

    public ShoppingCart(){
        items = new ArrayList<>();
    }

    public boolean addItem(String name, double value){
        if (value > 0)
            return items.add(new ShoppingItem(name, value));
        return false;
    }

    public boolean removeItem(String name){
        try {
            return items.remove(items.stream().filter(i -> i.getName().equals(name)).findFirst().get());

        }catch (NoSuchElementException e){ return false; /* why check before if we can just catch the exception? */}
    }

    public double calculateTotal(){
        return items.stream().mapToDouble(ShoppingItem::getValue).sum();
    }

    public int getItemCount(){
        return items.size();
    }
}
