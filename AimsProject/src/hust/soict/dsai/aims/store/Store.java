package src.hust.soict.dsai.aims.store;

import src.hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[10]; // hust.soict.dsai.aims.store.Store with max capacity of 10 DVDs
    private int currentIndex = 0; // Index to track the current position for the DVDs in the store

    // Method to add a DVD to the store
    public void addDVD(DigitalVideoDisc dvd) {
        if (currentIndex < itemsInStore.length) {
            itemsInStore[currentIndex] = dvd;
            currentIndex++;
            System.out.println("Added: " + dvd.getTitle());
        } else {
            System.out.println("hust.soict.dsai.aims.store.Store is full, cannot add more DVDs.");
        }
    }

    // Method to remove a DVD from the store by title
    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < currentIndex; i++) {
            if (itemsInStore[i] != null && itemsInStore[i].getId() == dvd.getId()) {
                // Shift the remaining DVDs to the left
                for (int j = i; j < currentIndex - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[currentIndex - 1] = null;
                currentIndex--;
                System.out.println("Removed: " + dvd.getTitle());
                return;
            }
        }
        System.out.println("DVD not found in the store.");
    }

    // Method to print all DVDs in the store
    public void printStore() {
        if (currentIndex == 0) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("DVDs in store:");
            for (int i = 0; i < currentIndex; i++) {
                System.out.println(itemsInStore[i]);
            }
        }
    }
}
