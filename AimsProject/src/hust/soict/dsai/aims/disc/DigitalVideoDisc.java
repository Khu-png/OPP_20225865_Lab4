package src.hust.soict.dsai.aims.disc;


public class DigitalVideoDisc {
    private String title;
    private final String category;
    private final String director;
    private final int length;
    private final float cost;

    private static int nbDigitalVideoDiscs = 0;
    private final int id;

    // Constructor with all attributes
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = (director != null) ? director : "Unknown";
        this.length = length;
        this.cost = cost;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor with title, category, and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this(title, category, "Unknown", 0, cost);  // Default values for director and length
    }

    // Constructor with only title
    public DigitalVideoDisc(String title) {
        this(title, "Unknown", "Unknown", 0, 0.0f); // Default values for other fields
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Method to check title match (case-insensitive)
    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    // Override toString method
    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + (director != null ? director : "Unknown") + " - " + length + ": " + cost + " $";
    }
}
