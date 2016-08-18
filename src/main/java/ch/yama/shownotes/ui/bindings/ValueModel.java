package ch.yama.shownotes.ui.bindings;

import java.beans.PropertyChangeListener;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.beans.BeanUtils;

public class ValueModel<B extends AbstractModel> extends AbstractModel {

	private B m_bean;
	private String m_propertyName;
	private Method m_writeMethod;

	public ValueModel(B bean, String propertyName) {
		this.m_bean = bean;
		this.m_propertyName = propertyName;
		PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(m_bean.getClass(), m_propertyName);
		m_writeMethod = propertyDescriptor.getWriteMethod();

		bean.addPropertyChangeListener(propertyName, e -> {
			firePropertyChange("value", e.getOldValue(), e.getNewValue());
		});
	}

	public void setValue(Object value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		m_writeMethod.invoke(m_bean, value);
	}

	public void addValueChangeListener(PropertyChangeListener listener) {
		addPropertyChangeListener("value", listener);
	}
}
