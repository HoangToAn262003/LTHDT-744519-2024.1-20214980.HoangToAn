package hust.soict.hedspi.aims.screen.sub;

import hust.soict.hedspi.aims.screen.StoreScreen;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class AddCDToStoreScreenController {
	private Store store;
	private StoreScreen storeScreen;
	
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnAddTrack;
	@FXML
	private TextField tfTitle;
	@FXML
	private TextField tfArtist;
	@FXML
	private TextField tfCost;
	@FXML
	private TextField tfTrackTitle;
	@FXML
	private TextField tfTrackLength;
	@FXML
	private TableView<Track> tblTrack;
	@FXML
	private TableColumn<Track, String> colTrackTitle;
	@FXML
	private TableColumn<Track, Integer> colTrackLength;
	
	private BorderStroke tfHighlight = new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(3f), BorderWidths.DEFAULT);
	private ObservableList<Track> tracks = FXCollections.observableArrayList();
	
	@FXML
	private void initialize() {
		colTrackTitle.setCellValueFactory(new PropertyValueFactory<Track, String>("title"));
		colTrackLength.setCellValueFactory(new PropertyValueFactory<Track, Integer>("length"));
	}
	
	@FXML
	void btnAddTrackPressed(ActionEvent evt) {
		if (tfTrackTitle.getText() == null) {
			tfTrackTitle.setBorder(new Border(tfHighlight));
		} else {
			tracks.add(new Track(tfTrackTitle.getText(), Integer.parseInt(tfTrackLength.getText())));
		}
	}
	
	@FXML
	void btnAddPressed(ActionEvent evt) {
		if (tfTitle.getText() == null) {
			tfTitle.setBorder(new Border(tfHighlight));
		} else {
			CompactDisc cd = new CompactDisc(tfTitle.getText(), tfArtist.getText(), Float.parseFloat(tfCost.getText()));
			for (Track t : tracks) {
				cd.addTrack(t.getTitle(), t.getLength());
			}
			store.addMedia(cd);
			
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
