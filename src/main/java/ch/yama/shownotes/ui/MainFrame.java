package ch.yama.shownotes.ui;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame {

	private JFrame m_frame;

	public MainFrame() {
		this.m_frame = new JFrame();
		this.m_frame.setSize(1024, 768);
		this.m_frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.m_frame.setTitle("yama-shownotes");
		this.m_frame.setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		menuBar.add(fileMenu);

		JMenuItem fileExitMenuItem = new JMenuItem(new AbstractAction("Exit") {
			private static final long serialVersionUID = 8060213779284285898L;

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileExitMenuItem.setMnemonic('x');
		fileMenu.add(fileExitMenuItem);

		menuBar.add(fileMenu);

		this.m_frame.setJMenuBar(menuBar);

		MainPanel mainPanel = new MainPanel();
		this.m_frame.add(mainPanel.getPanel());

		this.m_frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.m_frame.pack();
		this.m_frame.setVisible(true);
	}

}
