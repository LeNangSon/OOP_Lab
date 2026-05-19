package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media newMedia){
        if(itemsOrdered.size() == MAX_NUMBER_ORDERED){
            System.out.println("The cart is full!!!");
            return;
        }
        if(itemsOrdered.contains(newMedia)){
            System.out.println("Already Existed!!");
            return;
        }
        itemsOrdered.add(newMedia);
        System.out.println("This media has been added");
    }

    public void removeMedia(Media dlMedia){
        if(!itemsOrdered.contains(dlMedia)){
            System.out.println("The media is not in the cart!!");
            return;
        }
        itemsOrdered.remove(dlMedia);
        System.out.println("This media has been removed from the cart");
    }



    public float totalCost(){
        float sum =  0;
        for(Media tmp : itemsOrdered){
            sum += tmp.getCost();
        }
        return sum;
    }
    public void viewCart1(){
        if(itemsOrdered.isEmpty()){
            System.out.println("The cart is empty");
            return;
        }
        for(int i = 0; i < itemsOrdered.size();i++){
            System.out.println(itemsOrdered.get(i).getTitle());
        }
    }
    public void viewCart2(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for(int i = 0; i < itemsOrdered.size(); i++){
            System.out.println(itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public java.util.ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void print() {
        viewCart2();
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        addMedia(dvd);
    }

    public void searchById(int id) {
        boolean matchFound = false;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getId() == id) {
                System.out.println("Found match for ID " + id + ":");
                System.out.println(itemsOrdered.get(i).toString());
                matchFound = true;
                break;
            }
        }
        if (!matchFound) {
            System.out.println("No match found for ID: " + id);
        }
    }
    public Media searchByTitle(String title) {
        if (title == null || title.trim().isEmpty()) return null;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).isMatch(title)) {
                System.out.println("Found: " + itemsOrdered.get(i).toString());
                return itemsOrdered.get(i);
            }
        }
        System.out.println("No match found for title: \"" + title + "\"");
        return null;
    }

    public void filterById(int id) {
        searchById(id);
    }

    public void filterByTitle(String title) {
        boolean matchFound = false;
        System.out.println("Filter results for title: \"" + title + "\"");
        for (Media m : itemsOrdered) {
            if (m.isMatch(title)) {
                System.out.println(m.toString());
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("No match found for title: \"" + title + "\"");
        }
    }
}
