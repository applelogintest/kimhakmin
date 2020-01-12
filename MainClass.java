import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MainClass extends JFrame {
	Dummy2 dummy = new Dummy2();
	MyDeck deck = new MyDeck();
	CardLayout card = new CardLayout();

	public MainClass() {

		setLayout(card);
		add("DUM", dummy);

		setSize(1024, 1024);
		setVisible(true);// 윈도우 보여라
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MainClass();

	}

	

}
