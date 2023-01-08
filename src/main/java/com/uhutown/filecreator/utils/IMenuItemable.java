package com.uhutown.filecreator.utils;

import java.lang.reflect.Field;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public interface IMenuItemable {

	public void openUI(final Stage stage);

	public void lookForTypes(final Field field, final GridPane pane);

}
