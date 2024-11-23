
public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc[] d_arr = new DigitalVideoDisc[3];
		d_arr[0] = new DigitalVideoDisc("Super Mario Bros.");
		d_arr[1] = new DigitalVideoDisc("Shrek");
		d_arr[2] = new DigitalVideoDisc("Neon Genesis Evangelion");
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Sonic the Hedgehog");
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Puss in Boots: The Last Wish");
//		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Spirited Away");
		anOrder.addDigitalVideoDisc(d_arr);
		anOrder.addDigitalVideoDisc(dvd4, dvd5);
		
		System.out.println("Total cost is: " + anOrder.totalCost());
		
		anOrder.removeDigitalVideoDisc(dvd3);
		System.out.println("Total cost is: " + anOrder.totalCost());
	}

}
