package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

	@FXML
	private Pane drawingAreaPane;
	@FXML
	private ToggleGroup toggleTools;
	@FXML
	private Color thisColor = Color.BLACK;
	
	@FXML
	void clearButtonPressed(ActionEvent evt) {
		drawingAreaPane.getChildren().clear();
	}
	
	@FXML
	void drawingAreaMouseDragged(MouseEvent evt) {
		Circle newCircle = new Circle(evt.getX(), evt.getY(), 4, thisColor);
		drawingAreaPane.getChildren().add(newCircle);
	}
	
	@FXML
	void penRB(ActionEvent evt){
		thisColor = Color.BLACK;
	}
	
	@FXML
	void eraserRB(ActionEvent evt){
		thisColor = Color.WHITE;
	}
}
