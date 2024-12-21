package hust.soict.hedspi.aims.screen;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.screen.sub.*;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
	private Store store;
	private StoreScreen scrStore;
	
	@FXML
	private TableView<Media> tblMedia;
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	@FXML
	private Button btnPlay;
	@FXML
	private Button btnRemove;
	@FXML
	private Button btnOrder;
	@FXML
	private Label lblCost;
	
	public CartScreenController(Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store = store;
	}
	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						if (newValue != null) {
							updateButtonBar(newValue);
						}
					}
				}
				);
		updateLabelCost();
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}
	
	@FXML
	void btnRemovePressed(ActionEvent evt) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
	}
	
	@FXML
	void btnOrderPressed(ActionEvent evt) {
		JFrame f = new JFrame();
		JDialog d = new JDialog(f, "Making an order", true);
		if (cart.getItemsOrdered().size() > 0) {
			cart.clearCart();
			updateLabelCost();
			d.add(new JLabel("You have successfully made the order!"));
			d.setSize(500, 100);
			d.setVisible(true);
		} else {
			d.add(new JLabel("Cart is empty."));
			d.setSize(200, 100);
			d.setVisible(true);
		}
	}
	
	@FXML
	void btnPlayPressed(ActionEvent evt) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		JFrame f = new JFrame();
		JDialog d = new JDialog(f, "Playing media", true);
		
		d.add(new JLabel("Now playing: " + media.getTitle()));
		d.setSize(100, 25);
		d.setVisible(true);
	}
	
	void updateLabelCost() {
		lblCost.setText(cart.totalCost() + " $");
	}
	
	@FXML
	void addBookToStore(ActionEvent evt) {
		new AddBookToStoreScreen(store);
	}
	
	@FXML
	void addDVDToStore(ActionEvent evt) {
		new AddDVDToStoreScreen(store);
	}
	
	@FXML
	void addCDToStore(ActionEvent evt) {
		new AddCDToStoreScreen(store);
	}
}
