package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    protected Media() {}

    protected Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getCategory(){
        return category;
    }

    public String getTitle() {
        return title;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isMatch(String title) {
        if (title == null || title.trim().isEmpty() || this.title == null) {
            return false;
        }
        return this.title.toLowerCase().contains(title.toLowerCase());
    }


    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            Comparator.comparing(Media::getTitle)
                    .thenComparing(Media::getCost);

    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            Comparator.comparing(Media::getCost)
                    .thenComparing(Media::getTitle);
}
