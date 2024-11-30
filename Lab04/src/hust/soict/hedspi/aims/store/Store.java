package hust.soict.hedspi.aims.store;
import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media... ms) {
		for (Media m : ms) {
			itemsInStore.add(m);
		}
		System.out.println(ms.length + " item(s) have been added to the store! ("+ itemsInStore.size() + " item(s) in store)");
	}
	
	public void removeMedia(Media media) {
		for (Media m : itemsInStore) {
			if (m.getTitle().equals(media.getTitle())) {
				itemsInStore.remove(m);
				System.out.println(media.getTitle() + " has been removed from the store ("+ itemsInStore.size() + " item(s) in store).");
			}
		}
	}
	public String toString(Media m) {
		return m.getId() +". " + m.getTitle() + " - " + m.getCategory() + " - " + m.getCost() + "$";
	}
	
	public void print() {
		System.out.println("*********************** STORE ***********************");
		System.out.println("Ordered Items:");
		for (Media m : itemsInStore) {
			System.out.println(toString(m));
		}
	}
}
