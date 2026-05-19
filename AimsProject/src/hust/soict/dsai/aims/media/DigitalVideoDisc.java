package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;
    private int length;
    private static int nbDigitalVideoDiscs = 0;


    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }


    public boolean isMatch(String title) {
        if (title == null || title.trim().isEmpty()) {
            return false;
        }

        String lowerCaseTitle = this.getTitle().toLowerCase();

        String[] keywords = title.toLowerCase().split("\\s+");

        for (String word : keywords) {
            if (lowerCaseTitle.contains(word)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString(){
        return this.getId() + ". DVD - "+ this.getTitle() + " - " + this.getCategory() + " - " + director + " - " + length + ": "+this.getCost() + "$";
    }

    public DigitalVideoDisc(String title) {
        super();
        this.setTitle(title);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, cost);
        this.director = director;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(title, category, director, cost);
        this.length = length;
    }
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
