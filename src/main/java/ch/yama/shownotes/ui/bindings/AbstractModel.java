package ch.yama.shownotes.ui.bindings;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AbstractModel {

	private final PropertyChangeSupport m_pl = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		m_pl.addPropertyChangeListener(listener);
	}

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		m_pl.addPropertyChangeListener(propertyName, listener);
	}

	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		m_pl.firePropertyChange(propertyName, oldValue, newValue);
	}


}
