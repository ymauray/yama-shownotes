package ch.yama.shownotes.ui.base;

import javax.swing.JPanel;

import ch.yama.shownotes.ui.bindings.AbstractModel;
import ch.yama.shownotes.ui.bindings.UIModel;

/**
 *
 * @author yannick
 *
 */
public abstract class AbstractPanel<B extends AbstractModel> {

	private UIModel<B> m_uiModel;

	/**
	 *
	 */
	private JPanel panel;

	protected AbstractPanel(UIModel<B> uiModel) {
		m_uiModel = uiModel;
	}

	/**
	 *
	 * @return JPanel.
	 */
	public final JPanel getPanel() {
		return this.panel;
	}

	/**
	 *
	 * @param panel JPanel.
	 */
	public final void setPanel(final JPanel panel) {
		this.panel = panel;
	}

	public UIModel<B> getUiModel() {
		return m_uiModel;
	}

}
