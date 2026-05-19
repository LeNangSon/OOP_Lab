package hust.soict.dsai.aims.media;

public abstract class Media {
    private static int nbMedia = 0;
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {
        this.id = ++nbMedia;
    }

    protected void setCategory(String category) {
        this.category = category;
    }

    protected void setCost(float cost) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Media)) {
            return false;
        }

        Media other = (Media) obj;

        if (this.getTitle() != null && this.getTitle().equals(other.getTitle())) {
            return true;
        }

        return false;
    }
}
