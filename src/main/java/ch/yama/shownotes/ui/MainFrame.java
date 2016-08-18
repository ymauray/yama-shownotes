package ch.yama.shownotes.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MainFrame {

	private JFrame m_frame;

	public MainFrame() {
		this.m_frame = new JFrame();
		this.m_frame.setSize(320, 200);
		this.m_frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.m_frame.setTitle("yama-shownotes");
		this.m_frame.setLocationRelativeTo(null);

		MainPanel mainPanel = new MainPanel();
		this.m_frame.add(mainPanel.getPanel());

		this.m_frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.m_frame.setVisible(true);
	}

}
