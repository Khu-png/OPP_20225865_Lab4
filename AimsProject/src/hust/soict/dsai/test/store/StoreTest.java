package src.hust.soict.dsai.test.store;


import src.hust.soict.dsai.aims.disc.DigitalVideoDisc;
import src.hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Create a store instance
        Store store = new Store();

        // Create some DVD instances
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 24.95f);

        // Test adding DVDs to the store
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Print DVDs in the store
        store.printStore();

        // Test removing a DVD from the store
        store.removeDVD(dvd2);
        store.printStore();

        // Try removing a DVD that doesn't exist
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Non-Existing DVD");
        store.removeDVD(dvd4);

        // Test adding more DVDs if space allows
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Matrix", "Action", "Wachowski", 136, 19.99f);
        store.addDVD(dvd5);
        store.printStore();
    }
}
