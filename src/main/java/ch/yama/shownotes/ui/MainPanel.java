package ch.yama.shownotes.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

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

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		setPanel(panel);

		initComponents();
		initListeners();
	}

	/**
	 *
	 */
	private void initComponents() {
		JPanel centerPanel = new JPanel();
		JLabel label1 = new JLabel("Hello, world !");
		centerPanel.add(label1);

		m_textField1 = new JTextField(15);
		BindUtils.bind(m_textField1, getUiModel().getModel("nom"), true);
		centerPanel.add(m_textField1);

		m_button1 = new JButton("Okay!");
		centerPanel.add(m_button1);

		getPanel().add(centerPanel, BorderLayout.CENTER);

		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout());
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Podcasts");

		DefaultMutableTreeNode podcast = new DefaultMutableTreeNode("Euterpia Radio");
		rootNode.add(podcast);
		DefaultMutableTreeNode episode = new DefaultMutableTreeNode("073");
		podcast.add(episode);
		episode = new DefaultMutableTreeNode("074");
		podcast.add(episode);
		episode = new DefaultMutableTreeNode("075");
		podcast.add(episode);
		podcast = new DefaultMutableTreeNode("Euterpia Radio Rock");
		rootNode.add(podcast);
		podcast = new DefaultMutableTreeNode("The Bugcast");
		rootNode.add(podcast);
		episode = new DefaultMutableTreeNode("423");
		podcast.add(episode);
		podcast = new DefaultMutableTreeNode("AMPed");
		rootNode.add(podcast);
		podcast = new DefaultMutableTreeNode("CCJam");
		rootNode.add(podcast);

		JTree tree = new JTree(rootNode);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		JScrollPane scroll = new JScrollPane(tree);
		leftPanel.add(scroll);
		getPanel().add(leftPanel, BorderLayout.WEST);
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
