package com.uhutown.filecreator.buttons;

import com.uhutown.filecreator.modelfiles.ModelRenderFile;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewFileButton extends Button {

	public NewFileButton(final String name) {
		super(name);
	}

	public void loadNewFileScene(final Stage stage) {
		final GridPane pane = new GridPane();
		final CheckBox box = new CheckBox("Create!");
		final MenuButton menu = new MenuButton("FileTypes");

		final ModelRenderFile modelRender = new ModelRenderFile();

		menu.getItems().add(modelRender);
		menu.getItems().add(new MenuItem("Test"));

		pane.setPrefSize(300, 300);
		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.setHgap(30);
		pane.setVgap(50);
		pane.setAlignment(Pos.CENTER);
		pane.add(menu, 0, 0);
		pane.add(box, 0, 1);

		box.setOnAction(e -> {
			if (box.isSelected()) {
				modelRender.openUI(stage);
			}
		});

		final Scene scene = new Scene(pane, 700, 700);
		stage.setScene(scene);
		stage.show();
	}

}