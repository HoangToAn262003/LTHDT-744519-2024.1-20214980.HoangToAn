package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Aims {
	static Store s = new Store();
	static Cart c = new Cart();
	static ArrayList<DigitalVideoDisc> dvds = new ArrayList<DigitalVideoDisc>();
	static boolean onShowMenu, onStoreMenu, onMediaDetailsMenu, onCartMenu;
	static Scanner sc = new Scanner(System.in);
	
	public static void updateStoreMenu() {
		System.out.println("Store update?");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media");
		System.out.println("2. Remove media");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 1-2");
	}
	
	public static void processUpdateStore(int choice) {
		String title;
		switch(choice) {
		case 1:
			System.out.println("Choose media type:");
			System.out.println("1. DigitalVideoDisc (Title)");
			choice = sc.nextInt();
			if (choice == 1) {
				System.out.print("Enter title: ");
				title = sc.next();
				s.addMedia(new DigitalVideoDisc(title));
			}
			break;
			
		case 2:
			System.out.println("Enter title of the media to remove from store");
			title = sc.next();
			for (Media m : s.getItemsInStore()) {
				if (m.isMatch(title)) {
					s.removeMedia(m);
				}
			}
			
		default:
			return;
		}
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void processStoreMenu(int choice) {
		Media foundMedia = null;
		String title;
		while(onStoreMenu == true) {
			switch(choice) {
			case 1:
				System.out.print("Enter title of the media: ");
				title = sc.next();
				
				for (Media m : s.getItemsInStore()) {
					if (m.isMatch(title)) {
						foundMedia = m;
						mediaDetailsMenu();
						onMediaDetailsMenu = true;
						int choiceMedia = sc.nextInt();
						processMediaDetailsMenu(choiceMedia, foundMedia);
					}
				}
				break;
				
			case 2:
				System.out.print("Enter title of the media to add to cart: ");
				title = sc.next();
				
				for (Media m : s.getItemsInStore()) {
					if (m.isMatch(title)) {
						c.addMedia(m);
						if (m instanceof DigitalVideoDisc) {
							dvds.add((DigitalVideoDisc) m);
							System.out.println("DVD added! (" + dvds.size() + " DVD(s) in cart)");
						}
					}
				}
				choice = -1;
				break;
				
			case 3:
				System.out.print("Enter title of the media to play: ");
				title = sc.next();
				
				for (Media m : s.getItemsInStore()) {
					if (m.isMatch(title)) {
						if (m instanceof Playable) ((Playable) m).play();
						else System.out.println("Media is unplayable.");
					}
				}
				break;
				
			case 4:
				c.print();
				cartMenu();
				onCartMenu = true;
				choice = sc.nextInt();
				processCartMenu(choice);
				break;
				
			case 0:
				onStoreMenu = false;
				return;
				
			default:
				storeMenu();
				choice = sc.nextInt();
				break;
			}
		}
	}

	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void processMediaDetailsMenu(int choice, Media m) {
		while(onMediaDetailsMenu == true) {
			switch(choice) {
			case 1:
				c.addMedia(m);
				if (m instanceof DigitalVideoDisc) {
					dvds.add((DigitalVideoDisc) m);
					System.out.println("DVD added! (" + dvds.size() + " DVD(s) in cart)");
				}
				onMediaDetailsMenu = false;
				break;
				
			case 2:
				if (m instanceof Playable) ((Playable) m).play();
				else System.out.println("Media is unplayable.");
				onMediaDetailsMenu = false;
				break;
				
			case 0:
				onMediaDetailsMenu = false;
				return;
				
			default:
				break;
			}
		}
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	public static void processCartMenu(int choice) {
		String title;
		while(onCartMenu == true) {
			switch(choice) {
			
			case 1:
				System.out.println("Filter options:");
				System.out.println("1. By ID");
				System.out.println("2. By title");
				choice = sc.nextInt();
				if (choice == 1) {
					System.out.print("Enter ID: ");
					int id = sc.nextInt();
					c.searchID(id);
				}
				if (choice == 2) {
					System.out.print("Enter title: ");
					title = sc.next();
					c.searchTitle(title);
				}
				break;
				
			case 2:
				System.out.println("Sort options:");
				System.out.println("1. By title");
				System.out.println("2. By cost");
				choice = sc.nextInt();
				if (choice == 1) {
					Collections.sort(c.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
				}
				if (choice == 2) {
					Collections.sort(c.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
				}
				break;
			
			case 3:
				System.out.print("Enter title of the media to remove: ");
				title = sc.next();
				for (Media m : c.getItemsOrdered()) {
					if (m.isMatch(title)) {
						if (m instanceof DigitalVideoDisc) {
							dvds.remove(m);
						}
						c.removeMedia(m);
					}
				}
				break;
				
			case 4:
				System.out.print("Enter title of the media to play: ");
				title = sc.next();
				for (Media m : c.getItemsOrdered()) {
					if (m.isMatch(title)) {
						if (m instanceof Playable) ((Playable) m).play();
						else System.out.println("Media is unplayable.");
					}
				}
				break;
				
			case 5:
				System.out.println("An order has been created!");
				c = new Cart();
				break;
				
			case 0:
				onCartMenu = false;
				return;
				
			default:
				break;
			}
		}
	}
	
	public static void initStore() {
		CompactDisc cd = new CompactDisc("Pokémon Sun and Moon Original Soundtrack", " ", 29.99f);
		DigitalVideoDisc dvd = new DigitalVideoDisc("Shrek", "Fantasy", 9.99f);
		Book b = new Book("Diary of a Wimpy Kid");
		Disc d = new Disc("Memory of You");

		s.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f), new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f), new DigitalVideoDisc("Aladdin", "Animation", 18.99f), new DigitalVideoDisc("Super Mario Bros."), cd, dvd, b, d);
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void main(String[] args) {
		int choice;
		
		initStore();
		showMenu();
		onShowMenu = true;
		
		while(onShowMenu == true) {
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				s.print();
				storeMenu();
				onStoreMenu = true;
				choice = sc.nextInt();
				processStoreMenu(choice);
				break;
				
			case 2:
				s.print();
				updateStoreMenu();
				choice = sc.nextInt();
				processUpdateStore(choice);
				break;
				
			case 3:
				c.print();
				cartMenu();
				onCartMenu = true;
				choice = sc.nextInt();
				processCartMenu(choice);
				break;
				
			case 0:
				onShowMenu = false;
				
			default:
				showMenu();
				choice = sc.nextInt();
				break;
			}
			break;
		}
		sc.close();
	}

}
