//	Hoàng Tố An - 20214980

public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println(disc.getTitle() + " has been successfully added to cart! (" + qtyOrdered + " item(s) in cart)");
			if (MAX_NUMBERS_ORDERED - qtyOrdered < 3) {
				System.out.println("WARNING: Cart is almost full. (" + (MAX_NUMBERS_ORDERED - qtyOrdered) + " left)");
			}
		} else {
			System.out.println("ERROR: Unable to add " + disc.getTitle() + " to cart.");
		}
	}
	
//	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
//		if (dvdList.length + qtyOrdered <= MAX_NUMBERS_ORDERED) {
//			for (int i = 0; i < dvdList.length; i++) {
//				itemsOrdered[qtyOrdered] = dvdList[i];
//				qtyOrdered++;
//			}
//			System.out.println(dvdList.length + " item(s) have been added to cart! (" + qtyOrdered + " item(s) in cart)");
//		}
//		else {
//			System.out.println("ERROR: Unable to add items to cart.");
//		}
//	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
		if (dvdList.length + qtyOrdered <= MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < dvdList.length; i++) {
				itemsOrdered[qtyOrdered] = dvdList[i];
				qtyOrdered++;
			}
			System.out.println(dvdList.length + " item(s) have been added to cart! (" + qtyOrdered + " item(s) in cart)");
		}
		else {
			System.out.println("ERROR: Unable to add items to cart.");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
		if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd1;
			itemsOrdered[qtyOrdered + 1] = dvd2;
			qtyOrdered += 2;
			System.out.println("2 items have been added to cart! (" + qtyOrdered + " item(s) in cart)");
		}
		else {
			System.out.println("ERROR: Unable to add items to cart.");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getTitle().equals(disc.getTitle())) {
				for (int j = i; j < qtyOrdered; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				qtyOrdered--;
				System.out.println(disc.getTitle() + " has been removed from cart ("+ qtyOrdered + " item(s) in cart).");
			}
		}
	}
	
	public float totalCost() {
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}
	
	public void print() {
		System.out.println("*********************** CART ***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(toString(itemsOrdered[i]));
		}
		System.out.println("Total cost: " + totalCost());
	}
	
	public String toString(DigitalVideoDisc dvd) {
		return dvd.getId() +". " + dvd.getTitle() + " - " + dvd.getCategory() + " - " + dvd.getDirector()+ " - " + dvd.getLength() + " - " + dvd.getCost() + "$";
	}
	
	public void searchID(int id) {
		int count = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				System.out.println("Found: " + toString(itemsOrdered[i]));
				count++;
			}
		}
		if (count <= 0) {
			System.out.println("No match is found for the ID \"" + id + "\".");
		}
	}
	
	public void searchTitle(String title) {
		int count = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title)) {
				System.out.println("Found: " + toString(itemsOrdered[i]));
				count++;
			}
		}
		if (count <= 0) {
			System.out.println("No match is found for the title \"" + title + "\".");
		}
	}
}
