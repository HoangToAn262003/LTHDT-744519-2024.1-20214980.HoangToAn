package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAXINSTORE = 200;
	private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAXINSTORE];
	private int sz;
	
	public void addDVD(DigitalVideoDisc... dvdList) {
		for (int i = 0; i < dvdList.length; i++) {
			itemsInStore[sz] = dvdList[i];
			sz++;
		}
		System.out.println(dvdList.length + " item(s) have been added to the store! ("+ sz + " item(s) in store)");
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
		for (int i = 0; i < sz; i++) {
			if (itemsInStore[i].getTitle().equals(dvd.getTitle())) {
				for (int j = i; j < sz; j++) {
					itemsInStore[j] = itemsInStore[j+1];
					sz--;
				}
				System.out.println(dvd.getTitle() + " has been removed from the store ("+ sz + " item(s) in store).");
			}
		}
	}
	public String toString(DigitalVideoDisc dvd) {
		return dvd.getId() +". " + dvd.getTitle() + " - " + dvd.getCategory() + " - " + dvd.getDirector()+ " - " + dvd.getLength() + " - " + dvd.getCost() + "$";
	}
	
	public void print() {
		System.out.println("*********************** STORE ***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < sz; i++) {
			System.out.println(toString(itemsInStore[i]));
		}
	}
}
