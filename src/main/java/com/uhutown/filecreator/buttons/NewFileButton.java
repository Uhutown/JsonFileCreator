package com.uhutown.filecreator.buttons;

import com.uhutown.filecreator.utils.FileTypes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewFileButton extends Button {

	private static final String NOTVALID = "This type is not valid!";

	public NewFileButton(final String name) {
		super(name);
	}

	public void loadNewFileScene(final Stage stage) {
		final GridPane pane = new GridPane();
		final Button create = new Button("Create!");
		final TextField field = new TextField();

		field.setPrefSize(1, 50);

		pane.setPrefSize(300, 300);
		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.setHgap(30);
		pane.setVgap(50);
		pane.setAlignment(Pos.CENTER);
		pane.add(field, 0, 0);
		pane.add(create, 0, 1);

		create.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent arg0) {
				final Text text = new Text();
				final String type = field.getText();
				for (final FileTypes file : FileTypes.values()) {
					if (file.name().equalsIgnoreCase(type)) {
						System.out.println("Jo!");
						return;
					}
				}
				text.setText(NOTVALID);
				text.setFont(Font.font("Arial", FontWeight.BOLD, 15));
				pane.add(text, 0, 2);
			}
		});
		final Scene scene = new Scene(pane, 700, 700);
		stage.setScene(scene);
		stage.show();
	}

}