module JsonFileCreator {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	requires gson;
	requires java.sql;

	opens com.uhutown.filecreator.main to javafx.graphics, javafx.fxml;
	opens com.uhutown.filecreator.signalfiles to gson;
	opens com.uhutown.filecreator.modelfiles to gson;
	opens com.uhutown.filecreator.configfiles to gson;
}
