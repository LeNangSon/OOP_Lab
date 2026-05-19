package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

import java.util.ArrayList;

public class Store {
    public static final int MAX_NUMBER_MEDIA = 100;

    private final ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media newMedia){
        if(itemsInStore.size() == MAX_NUMBER_MEDIA){
            System.out.println("The store is full!!!");
            return;
        }
        if(itemsInStore.contains(newMedia)){
            System.out.println("Already Existed!!");
            return;
        }
        itemsInStore.add(newMedia);
        System.out.println("This media has been added");
    }

    public void removeMedia(Media dlMedia){
        if(!itemsInStore.contains(dlMedia)){
            System.out.println("The media is not in the Store!!");
            return;
        }
        itemsInStore.remove(dlMedia);
        System.out.println("This media has been removed from the cart");
    }
    public void viewCart1(){
        if(itemsInStore.isEmpty()){
            System.out.println("The store is empty");
            return;
        }
        for(int i = 0; i < itemsInStore.size();i++){
            System.out.println(itemsInStore.get(i).getTitle());
        }
    }

    public java.util.ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public Media searchByTitle(String title) {
        if (title == null || title.trim().isEmpty()) return null;
        for (Media m : itemsInStore) {
            if (m.isMatch(title)) {
                return m;
            }
        }
        return null;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        addMedia(dvd);
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        removeMedia(dvd);
    }
}
