import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MainClass extends JFrame implements ActionListener {
	Dummy dummy = new Dummy();
	MyDeck my_deck = new MyDeck(dummy);
	EnemyDeck e_deck = new EnemyDeck(dummy);
	GuessEnemyDeck guessEnemyDeck = new GuessEnemyDeck(e_deck);
	CardLayout card = new CardLayout();
	int first_choice = (int)(Math.random()*6);
	int my_count=0;
	int e_count=0;
	boolean turn_check = false;

	public MainClass() {

		setLayout(card);
		add("DUM", dummy);

		setSize(1024, 1024);
		setVisible(true);// 윈도우 보여라
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		if(first_choice < 3) {
			turn_check = true;
		}
		for(int i=0; i<24; i++)
		{
			dummy.bt[i].addActionListener(this);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MainClass();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(turn_check) { // my 차례
			for (int i = 0; i < 24; i++) {
				if (e.getSource() == dummy.bt[i]) {
					if(my_count < 4 ) //카드 4장이 들어오면 게임 시작
					{
						my_deck.mydeck_choice(i);
						turn_check = false; 
						my_count++; 
						break;
					}
					else
					{
						
					}
				}

			}
		}
		else { // enemy 차례
			for(int i=0; i<24; i++)	{
				if (e.getSource() == dummy.bt[i]) {
					if(e_count <4) // 카드 4장이 들어오면 게임 시작
					{
						e_deck.mydeck_choice(i);
						turn_check = true;
						e_count++;
						break;
					}
					else
					{
						
					}
				
				}
			}
		}
		
	}
}
