package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//	Hoàng Tố An - 20214980

public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public void addMedia(Media... ms) {
		if (itemsOrdered.size() + ms.length <= MAX_NUMBERS_ORDERED) {
			for (Media m : ms) {
				itemsOrdered.add(m);
			}
			System.out.println(ms.length + " item(s) have been added to cart (" + itemsOrdered.size() + " item(s) in cart).");
		}
		else {
			System.out.println("ERROR: Unable to add items to cart.");
		}
	}
	
	public void removeMedia(Media media) {
		for (Media m : itemsOrdered) {
			if (m.getTitle().equals(media.getTitle())) {
				itemsOrdered.remove(m);
				System.out.println(media.getTitle() + " has been removed from cart ("+ itemsOrdered.size() + " item(s) in cart).");
			}
		}
	}
	
	public float totalCost() {
		float total = 0;
		for (Media m : itemsOrdered) {
			total += m.getCost();
		}
		return total;
	}
	
	public void print() {
		System.out.println("*********************** CART ***********************");
		System.out.println("Ordered Items:");
		for (Media m : itemsOrdered) {
			System.out.println(toString(m));
		}
		System.out.println("Total cost: " + totalCost());
	}
	
	public String toString(Media m) {
		return m.getId() +". " + m.getTitle() + " - " + m.getCategory() + " - " + m.getCost() + "$";
	}
	
	public void searchID(int id) {
		int count = 0;
		for (Media m : itemsOrdered) {
			if (m.getId() == id) {
				System.out.println(toString(m));
				count++;
			}
		}
		if (count <= 0) {
			System.out.println("No match is found for the ID \"" + id + "\".");
		}
	}
	
	public void searchTitle(String title) {
		int count = 0;
		for (Media m : itemsOrdered) {
			if (m.isMatch(title)) {
				System.out.println(toString(m));
				count++;
			}
		}
		if (count <= 0) {
			System.out.println("No match is found for the title \"" + title + "\".");
		}
	}

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	public void clearCart() {
		itemsOrdered.clear();
	}
}
