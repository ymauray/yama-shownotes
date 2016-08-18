package ch.yama.shownotes.ui.bindings;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JTextField;

public final class BindUtils {

	public static <B extends AbstractModel> void bind(JTextField textField, ValueModel<B> valueModel) {
		bind(textField, valueModel, false);
	}

	public static <B extends AbstractModel> void bind(JTextField textField, ValueModel<B> valueModel,
			boolean commitOnFocusLost) {

		if (!commitOnFocusLost) {
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					setValue(textField, valueModel);
				}
			});
		} else {
			textField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					setValue(textField, valueModel);
				}
			});
		}

		valueModel.addValueChangeListener(e -> {
			textField.setText((String) e.getNewValue());
		});
	}

	static <B extends AbstractModel> void setValue(JTextField textField, ValueModel<B> valueModel) {
		final String text = textField.getText();
		try {
			valueModel.setValue(text);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
			e1.printStackTrace();
		}
	}
}
