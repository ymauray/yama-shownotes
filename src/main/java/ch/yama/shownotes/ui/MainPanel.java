package ch.yama.shownotes.ui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.yama.shownotes.ui.base.AbstractPanel;
import ch.yama.shownotes.ui.bindings.BindUtils;
import ch.yama.shownotes.ui.bindings.UIModel;

/**
 *
 * @author yannick
 *
 */
public class MainPanel extends AbstractPanel<MainPanelModel> {

	/**
	 *
	 */
	private JButton m_button1;
	private JTextField m_textField1;

	/**
	 *
	 */
	MainPanel() {
		super(new UIModel<>(new MainPanelModel()));
		setPanel(new JPanel());

		initComponents();
		initListeners();
	}

	/**
	 *
	 */
	private void initComponents() {
		JLabel label1 = new JLabel("Hello, world !");
		getPanel().add(label1);

		m_textField1 = new JTextField(15);
		BindUtils.bind(m_textField1, getUiModel().getModel("nom"), true);
		getPanel().add(m_textField1);

		m_button1 = new JButton("Okay!");
		getPanel().add(m_button1);
	}

	/**
	 *
	 */
	private void initListeners() {
		m_button1.addActionListener(e -> button1Click(e));

		getUiModel().addPropertyChangeListener("nom", e -> {
			System.out.println(e.toString());
		});
	}

	/**
	 *
	 * @param e ActioinEvent.
	 */
	private void button1Click(final ActionEvent e) {
		String name = m_textField1.getText();
		System.out.println(name);
		System.out.println(getUiModel().getBean().getNom());
		getUiModel().getBean().setNom("hello");
	}

	public JButton getButton1() {
		return m_button1;
	}
}
