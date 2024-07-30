import java.util.ArrayList;
import java.util.Scanner;

public class  GenericCatalog <T extends LibraryItem>{
    private  ArrayList<T> catalog = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public  ArrayList<T> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<T> catalog) {
        this.catalog = catalog;
    }
    public void addItem(T itemToAdd) {
        catalog.add(itemToAdd);
    }

    public void removeItem(T itemToRemove) {
        if (!catalog.contains(itemToRemove)) {
            System.out.println("Item not in the catalog.");
        } else {
            catalog.remove(itemToRemove);
            System.out.println("Item removed.");
        }
    }
    public void displayItemInfo(T itemToDisplay){
        for(T item: catalog){
        if(!catalog.contains(itemToDisplay)){
            System.out.println(itemToDisplay + " is not in the catalog");
        }
        else System.out.println("Title: "+ itemToDisplay.getTitle()
                + " author: " + itemToDisplay.getAuthor());
       }
    }
}
