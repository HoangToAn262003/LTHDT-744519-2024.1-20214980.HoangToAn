package hust.soict.hedspi.test.cart;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Sonic the Hedgehog 3", "Animation", "Sega", 109, 29.99f);
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-fi", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		cart.print();
		
		System.out.println("\n********** Search test **********");
		cart.searchID(3);
		cart.searchID(0);
		cart.searchTitle("sonic");
		cart.searchTitle("mario");
		
		cart.removeDigitalVideoDisc(dvd3);
		cart.searchID(3);
		cart.searchTitle("aLL");
	}

}
