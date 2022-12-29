module JsonFileCreator {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	requires gson;

	opens com.uhutown.filecreator.main to javafx.graphics, javafx.fxml;
}
