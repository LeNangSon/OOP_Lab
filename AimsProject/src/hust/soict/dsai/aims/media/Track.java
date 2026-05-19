package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Track)) {
            return false;
        }

        Track other = (Track) obj;

        boolean isTitleEqual = (this.getTitle() != null && this.getTitle().equals(other.getTitle()));
        boolean isLengthEqual = (this.getLength() == other.getLength());

        return isTitleEqual && isLengthEqual;
    }
    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("DVD Track: " + this.getLength());
    }
}
