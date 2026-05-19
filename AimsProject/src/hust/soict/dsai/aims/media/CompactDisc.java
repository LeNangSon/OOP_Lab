package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    public String getArtist(){
        return artist;
    }
    public CompactDisc(String artist) {
        super();
        this.artist = artist;
    }
    public void addTrack(Track newTrack){
        if(tracks.contains(newTrack)){
            System.out.println("Already Exist!!");
            return;
            }
        tracks.add(newTrack);
    }
    public void removeTrack(Track dlTrack){
        if(!tracks.contains(dlTrack)){
            System.out.println("Not found!!");
            return;
        }
        tracks.remove(dlTrack);
        System.out.println("Delete Sucessful!!");
    }
    public int getLength(){
        int totalLength = 0;
        for(Track tmp: tracks){
            totalLength += tmp.getLength();
        }
        return totalLength;
    }
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD Artist: " + this.artist);
        System.out.println("Total CD length: " + this.getLength());
        for(Track tmp: tracks){
            tmp.play();
        }
    }
}

