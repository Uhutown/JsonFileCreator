package com.uhutown.filecreator.main;

import com.uhutown.filecreator.buttons.NewFileButton;
import com.uhutown.filecreator.utils.Files;
import com.uhutown.filecreator.utils.GsonUtils;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

	private static final Text EXISTINGFILES = new Text("Existing Files: \n");

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
		final NewFileButton newFile = new NewFileButton("new File");
		final Button editFile = new Button("Edit File");
		final Button reload = new Button("Reload Files");

		EXISTINGFILES.setFont(Font.font("Arial", FontWeight.BOLD, 15));

		newFile.setPrefSize(200, 50);
		editFile.setPrefSize(200, 50);
		reload.setPrefSize(200, 30);

		final GridPane grid = new GridPane();

		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(30);
		grid.setVgap(50);
		grid.setPadding(new Insets(20, 20, 20, 20));

		grid.add(newFile, 0, 0);
		grid.add(editFile, 1, 0);
		grid.add(reload, 0, 1);

		final VBox vbox = new VBox();

		vbox.getChildren().add(EXISTINGFILES);
		showFiles(vbox);

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

		reload.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent arg0) {
				System.out.println("Reloading Files!");
				loadDefaultScreen(stage);

			}
		});
		newFile.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent arg0) {
				newFile.loadNewFileScene(stage);
			}
		});
	}

	private void showFiles(final VBox vbox) {
		final String allFiles = GsonUtils.readFileInfos();
		final Text files = new Text();
		if (allFiles.isEmpty()) {
			files.setText("No files existiing!");
		} else {
			files.setText(allFiles);
		}
		files.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
		vbox.getChildren().add(files);
	}
}