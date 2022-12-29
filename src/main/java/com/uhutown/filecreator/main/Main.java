package com.uhutown.filecreator.main;

import com.uhutown.filecreator.utils.Files;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		Files.intFiles();

		loadDefaultScreen(primaryStage);

		primaryStage.show();
	}

	private void loadDefaultScreen(final Stage stage) {
		final Button newFile = new Button("new File");
		final Button editFile = new Button("Edit File");

		final Text existingFiles = new Text("Existing Files: \n");
		existingFiles.setFont(Font.font("Arial", FontWeight.BOLD, 15));

		newFile.setPrefSize(200, 50);
		editFile.setPrefSize(200, 50);

		final GridPane grid = new GridPane();

		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(30);
		grid.setVgap(50);
		grid.setPadding(new Insets(20, 20, 20, 20));

		grid.add(newFile, 0, 0);
		grid.add(editFile, 1, 0);

		final VBox vbox = new VBox();

		final Text files = new Text("t \n\n\n test \n\n\n t");
		files.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
		vbox.getChildren().add(existingFiles);
		vbox.getChildren().add(files);

		final ScrollPane scrollPane = new ScrollPane(vbox);
		scrollPane.setPadding(new Insets(10));
		scrollPane.setMaxHeight(400);
		scrollPane.setMaxWidth(400);

		final BorderPane pane = new BorderPane(scrollPane);
		pane.setPadding(new Insets(30));
		pane.setTop(grid);

		final Scene scene = new Scene(pane, 700, 700);

		stage.setScene(scene);

		stage.setTitle("JsonFileCreator");
	}
}