package com.uhutown.filecreator.modelfiles;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;

import com.uhutown.filecreator.utils.IMenuItemable;

import javafx.geometry.Pos;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ModelRenderFile extends MenuItem implements IMenuItemable {

	public ModelRenderFile() {
		super("ModelRenderFile");
	}

	@Override
	public void openUI(final Stage stage) {
		final ModelStats stats = new ModelStats();
		final Field[] fields = stats.getClass().getDeclaredFields();
		final GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		for (final Field field : fields) {
			final int modifiers = field.getModifiers();
			if (!Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers)) {
				lookForTypes(field, pane);
			}
		}
	}

	@Override
	public void lookForTypes(final Field field, final GridPane pane) {
		try {
			if (field == null || !(field.get(null) instanceof Object)) {
				return;
			}
			final Object obj = field.get(null);
			if (obj == null) {
				return;
			}
			if (obj instanceof String || obj instanceof Number) {
				final TextField text = new TextField();
				pane.add(text, (int) pane.getLayoutX() + 1, (int) pane.getLayoutY() + 1);
				return;
			}
			if (obj instanceof List<?>) {
				final List<?> list = (List<?>) obj;
				final Type[] type = list.getClass().getTypeParameters();
				System.out.println(type);
			}
		} catch (final IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}
}