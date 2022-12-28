module JsonFileCreator {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;

	opens com.uhutown.filecreator.main to javafx.graphics, javafx.fxml;
}
