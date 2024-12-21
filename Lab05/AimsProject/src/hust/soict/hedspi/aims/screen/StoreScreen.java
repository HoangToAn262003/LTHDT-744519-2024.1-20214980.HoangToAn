package hust.soict.hedspi.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.screen.sub.AddBookToStoreScreen;
import hust.soict.hedspi.aims.screen.sub.AddCDToStoreScreen;
import hust.soict.hedspi.aims.screen.sub.AddDVDToStoreScreen;
import hust.soict.hedspi.aims.store.Store;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

public class StoreScreen extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Store store = new Store();
	private Cart cart = new Cart();
	
	public StoreScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(new JMenuItem("Add Book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));
		for (int i = 0; i < smUpdateStore.getItemCount(); i++) {
			smUpdateStore.getItem(i).addActionListener(new ButtonListener());
		}
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("View cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton btnCart = new JButton("View cart");
		btnCart.setPreferredSize(new Dimension(100, 50));
		btnCart.setMaximumSize(new Dimension(100, 50));
		btnCart.addActionListener(new ButtonListener());
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(btnCart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < 9; i++) {
			MediaStore cell = new MediaStore(cart, mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	static void dummyStore() {
		CompactDisc cd = new CompactDisc("Pokémon Sun and Moon Original Soundtrack", " ", 29.99f);
		DigitalVideoDisc dvd = new DigitalVideoDisc("Shrek", "Fantasy", 9.99f);
		Book b = new Book("Diary of a Wimpy Kid");
		Book b1 = new Book("Spiral into Madness");
		Disc d = new Disc("Memory of You");

		store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f), new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f), new DigitalVideoDisc("Aladdin", "Animation", 18.99f), new DigitalVideoDisc("Super Mario Bros."), cd, dvd, b, d, b1);
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			String btn = evt.getActionCommand();
			if (btn.equals("View cart")) {
				new CartScreen(cart, store);
			}
			if (btn.equals("Add Book")) {
				new AddBookToStoreScreen(store);
			};
			if (btn.equals("Add DVD")) {
				new AddDVDToStoreScreen(store);
			};
			if (btn.equals("Add CD")) {
				new AddCDToStoreScreen(store);
			};
		}
	}
	
	public static void main(String[] args) {
		dummyStore();
		new StoreScreen(store);
	}

}
