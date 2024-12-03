package src.hust.soict.dsai.aims.media;

public abstract class Media {
    private static int idCounter = 1; // Counter to auto-generate ID for each media object
    private final int id;
    private String title;
    private final String category;
    private float cost;

    // Constructor
    public Media(String title, String category, float cost) {
        this.id = idCounter++; // Auto-incrementing ID for each new media object
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // Method to check if the title matches
    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title); // Case-insensitive title comparison
    }

    @Override
    public String toString() {
        return "Media [id=" + id + ", title=" + title + ", category=" + category + ", cost=" + cost + "]";
    }

    // Override equals() to compare media based on title (case-insensitive)
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Media)) {
            return false;
        }
        Media other = (Media) obj;
        return this.title.equalsIgnoreCase(other.title);
    }

    // Override hashCode() to ensure compatibility with equals()
    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    // Abstract play method for subclasses like DigitalVideoDisc, CompactDisc, etc.
    // Subclasses will implement this method according to the type of media
    public abstract void play();
}
