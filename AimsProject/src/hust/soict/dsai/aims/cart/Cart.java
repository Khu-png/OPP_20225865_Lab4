package src.hust.soict.dsai.aims.cart;

import src.hust.soict.dsai.aims.media.Media;
import src.hust.soict.dsai.aims.media.Playable;
import java.util.ArrayList;
import java.util.Comparator;

public class Cart {
    private static final int MAX_NUMBERS_ORDERED = 20;
    private final ArrayList<Media> itemsOrdered = new ArrayList<>(); // Instance variable for media

    // Add Media to cart (could be DVD, Book, Compact Disc, etc.)
    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full, cannot add more items.");
        } else {
            itemsOrdered.add(media);
            System.out.println("The item " + media.getTitle() + " has been added.");
        }
    }

    // Remove Media from cart by Media object
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The item " + media.getTitle() + " has been removed.");
        } else {
            System.out.println("Item not found in the cart.");
        }
    }

    // Find Media by title in the cart
    public Media getMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                return media; // Return media if title matches
            }
        }
        return null; // If not found
    }

    // Print the cart with details
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("****************************************************");
    }

    // Calculate the total cost of all items in the cart
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Clear the cart (empty the cart)
    public void clearCart() {
        itemsOrdered.clear();  // This will remove all items in the cart
        System.out.println("The cart has been cleared.");
    }

    // Place order (empty the cart after placing the order)
    public void placeOrder() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("No items in the cart to place an order.");
        } else {
            System.out.println("Order placed successfully!");
            clearCart();  // Empty the cart after placing an order
        }
    }

    // Filter medias by title or ID
    public void filterMedias(String criterion, String value) {
        boolean found = false;
        System.out.println("Filter results:");
        if (criterion.equalsIgnoreCase("title")) {
            for (Media media : itemsOrdered) {
                if (media.isMatch(value)) {
                    System.out.println(media.toString());
                    found = true;
                }
            }
        } else if (criterion.equalsIgnoreCase("id")) {
            try {
                int id = Integer.parseInt(value);
                for (Media media : itemsOrdered) {
                    if (media.getId() == id) {
                        System.out.println(media.toString());
                        found = true;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format. Please provide a numeric ID.");
            }
        } else {
            System.out.println("Invalid filter criterion. Please use 'title' or 'id'.");
        }

        if (!found) {
            System.out.println("No media found matching the given criterion.");
        }
    }

    // Sort medias by title or cost
    public void sortMedias(String criterion) {
        if (criterion.equalsIgnoreCase("title")) {
            itemsOrdered.sort(Comparator.comparing(Media::getTitle));
        } else if (criterion.equalsIgnoreCase("cost")) {
            itemsOrdered.sort(Comparator.comparing(Media::getCost));
        } else {
            System.out.println("Invalid sort criterion.");
        }
        System.out.println("Cart has been sorted by " + criterion + ".");
    }

    // Play media (assuming media implements Playable interface)
    public void playMedia(Media media) {
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }
}
