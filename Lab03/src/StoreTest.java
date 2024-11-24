
public class StoreTest {

	public static void main(String[] args) {
		Store s = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Sonic the Hedgehog");
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Puss in Boots: The Last Wish");
		
		s.addDVD(dvd1, dvd2, dvd3, dvd4, dvd5);
		s.print();
		s.removeDVD(dvd4);
		s.print();
	}

}
