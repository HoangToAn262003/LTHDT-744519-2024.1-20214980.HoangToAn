
public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
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
}
