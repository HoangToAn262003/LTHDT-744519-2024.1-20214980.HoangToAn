package hust.soict.hedspi.aims.screen.sub;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.StoreScreen;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class AddDVDToStoreScreenController {
	private Store store;
	private StoreScreen storeScreen;
	
	public AddDVDToStoreScreenController(Store store) {
		super();
		this.store = store;
	}
	
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
	private TextField tfDirector;
	@FXML
	private TextField tfLength;
	
	private BorderStroke tfHighlight = new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(3f), BorderWidths.DEFAULT);

	@FXML
	void btnAddPressed(ActionEvent evt) {
		if (tfTitle.getText() == null) {
			tfTitle.setBorder(new Border(tfHighlight));
		} else {
			store.addMedia(new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), tfDirector.getText(), Integer.parseInt(tfLength.getText()), Float.parseFloat(tfCost.getText())));
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
