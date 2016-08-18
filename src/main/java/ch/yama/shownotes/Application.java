package ch.yama.shownotes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.yama.shownotes.ui.MainFrame;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", Boolean.toString(false));
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new MainFrame();
	}
}
