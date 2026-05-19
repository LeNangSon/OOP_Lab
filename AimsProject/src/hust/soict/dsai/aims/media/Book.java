package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<String>();

    public Book(){

    }
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if(authors.contains(authorName)){
            System.out.println("Already Exist !!");
            return;
        }
        authors.add(authorName);
    }
    public void removeAuthor(String authorName) {
        if(authors.remove(authorName)){
            System.out.println("Removed Successfully !!");
        }
        else{
            System.out.println("Not existed!!");
        }
    }
}
