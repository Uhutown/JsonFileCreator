package com.uhutown.filecreator.main;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void start(Stage primaryStage) {

		loadDefaultScreen(primaryStage);

		primaryStage.setTitle("Hallo Welt!");

		final Text text = new Text("This is a Text!");
		text.setFont(new Font(15));
		text.setX(50);
		text.setY(150);
		final Group root = new Group();
		final ObservableList list = root.getChildren();
		final Button button = new Button("Button!");
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent arg0) {
				primaryStage.setTitle("Test!");
			}
		});
		button.setLayoutX(150);
		button.setLayoutY(15);
		list.add(button);
		list.add(text);
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void loadDefaultScreen(final Stage stage) {
		final Text text = new Text("");
	}
}