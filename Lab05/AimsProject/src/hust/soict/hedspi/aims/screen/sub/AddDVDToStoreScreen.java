package hust.soict.hedspi.aims.screen.sub;

import java.io.IOException;

import javax.swing.JPanel;

import hust.soict.hedspi.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddDVDToStoreScreen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Store store;
	
	public AddDVDToStoreScreen(Store store) {
		super();
		this.store = store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/sub/AddDVDToStoreScreen.fxml"));
					AddDVDToStoreScreenController ctrl = new AddDVDToStoreScreenController(store);
					loader.setController(ctrl);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

}