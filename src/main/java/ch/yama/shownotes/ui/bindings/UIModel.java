package ch.yama.shownotes.ui.bindings;

import java.beans.PropertyChangeListener;

public class UIModel<B extends AbstractModel> {

	private B m_bean;

	public UIModel(B bean) {
		m_bean = bean;
	}

	public ValueModel<B> getModel(String propertyName) {
		return new ValueModel<>(m_bean, propertyName);
	}

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		m_bean.addPropertyChangeListener(propertyName, listener);
	}

	public B getBean() {
		return m_bean;
	}
}
