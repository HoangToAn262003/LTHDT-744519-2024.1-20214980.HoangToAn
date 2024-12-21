package hust.soict.hedspi.aims.screen.sub;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.screen.StoreScreen;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class AddBookToStoreScreenController {
	private Store store;
	private StoreScreen storeScreen;
	
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnAdd;
	@FXML
	private TextField tfTitle;
	@FXML
	private TextField tfCategory;
	@FXML
	private TextField tfCost;
	@FXML
	private TextField tfAuthor;
	
	private BorderStroke tfHighlight = new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(3f), BorderWidths.DEFAULT);
	
	@FXML
	void btnAddPressed(ActionEvent evt) {
		if (tfTitle.getText() == null) {
			tfTitle.setBorder(new Border(tfHighlight));
		} else {
			Book book = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()));
			book.addAuthor(tfAuthor.getText().split(","));
			
			store.addMedia(book);
			storeScreen.dispose();
			storeScreen = new StoreScreen(store);
		}
	}
	
	@FXML
	void btnCancelPressed(ActionEvent evt) {
		storeScreen.dispose();
		storeScreen = new StoreScreen(store);
	}
}
