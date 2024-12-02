package hust.soict.hedspi.test.media;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.*;

public class TestPolymorphism {

	public static void main(String[] args) {
		ArrayList<Media> mediae = new ArrayList<Media>();
		CompactDisc cd = new CompactDisc("Pokémon Sun and Moon Original Soundtrack", " ", 29.99f);
		DigitalVideoDisc dvd = new DigitalVideoDisc("Shrek", "Fantasy", 9.99f);
		Book b = new Book("Diary of a Wimpy Kid");
		Disc d = new Disc("Memory of You");
		
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(b);
		mediae.add(d);
		
		for(Media m : mediae) {
			System.out.println(m.toString());
		}

	}

}
