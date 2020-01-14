import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MainClass extends JFrame implements ActionListener {
	Dummy dummy = new Dummy();
	MyDeck my_deck = new MyDeck(dummy);
	EnemyDeck e_deck = new EnemyDeck(dummy);
	GuessEnemyDeck guessEnemyDeck = new GuessEnemyDeck();
	CardLayout card = new CardLayout();
	int first_choice = (int) (Math.random() * 6);
	int my_count = 0;
	int e_count = 0;
	boolean turn_check = false;

	public MainClass() {

		setLayout(card);
		add("DUM", dummy);

		setSize(1024, 1024);
		setVisible(true);// 윈도우 보여라
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		if (first_choice < 3) {
			turn_check = true;
		}
		for (int i = 0; i < 12; i++) {
			e_deck.e_bt.set(i, new JButton());
			e_deck.e_bt.get(i).addActionListener(this);
		}
		for (int i = 0; i < 24; i++) {
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

		if (turn_check) { // my 차례
			for (int i = 0; i < 24; i++) {
				if (e.getSource() == dummy.bt[i]) {
					if (my_count < 4) // 카드 4장이 들어오면 게임 시작
					{
						my_deck.mydeck_choice(i);
						turn_check = false;
						my_count++;
						
						for(int j=0; j<my_deck.my_bt.size(); j++)
						{
							e_deck.e_bt.get(j).setEnabled(false);
							my_deck.my_bt.get(j).setEnabled(false);
						}
						
						if(e_count == 4)
						{
							System.out.println("게임시작");
							
							
						}
						
						if(e_count > 5)
						{
							for(int z=0; z<my_deck.my_bt.size(); z++)
							{
								my_deck.my_bt.get(z).setEnabled(true);
							}
						}
						
						
						
						break;
					}

				}
			}
			for (int j = 0; j < 12; j++) {
				if (e.getSource() == e_deck.e_bt.get(j)) {
					guessEnemyDeck.getEnum(e_deck.sortNum.get(j)); // 누른 상대패의 값을 guessEnomyDeck으로 넘김
					guessEnemyDeck.guess(); // 다이얼로그 창뜨면서 상대덱 추측
					if (guessEnemyDeck.isRight()) { // 버튼의 숫자가 맞으면 true , 틀리면 false 리턴

						if (e_deck.sortNum.get(j) % 1 == 0.5) {

							int num = e_deck.sortNum.get(j).intValue(); // sortNum double형 어레이리스트 여서 더블형에 넣어줬다 인트형으로
																		// 변환
							e_deck.e_bt.get(j).setIcon(e_deck.card[num + 12].tail_fix);
						} else {
							int num = e_deck.sortNum.get(j).intValue();
							e_deck.e_bt.get(j).setIcon(e_deck.card[num].tail_fix);
						}
					} else {
						my_deck.my_bt.get(my_deck.my_bt.size() - 1).setContentAreaFilled(false);

					}
					turn_check = false;
					break;
				}
			}

		}

		else { // enemy 차례
			for (int i = 0; i < 24; i++) {
				if (e.getSource() == dummy.bt[i]) {
					if (e_count < 4) // 카드 4장이 들어오면 게임 시작
					{
						e_deck.mydeck_choice(i);
						turn_check = true;
						e_count++;
						
						for(int j=0; j<e_deck.e_bt.size(); j++)
						{
							e_deck.e_bt.get(j).setEnabled(false);
							my_deck.my_bt.get(j).setEnabled(false);
						}
						
						if(my_count == 4)
						{
							System.out.println("게임시작");
							for(int z=0; z<e_deck.e_bt.size(); z++)
							{
								e_deck.e_bt.get(z).setEnabled(true);
							}
							
						}
						
						
						break;
					}
				
					
				}
				for (int j = 0; j < 12; j++) {
					if (e.getSource() == my_deck.my_bt.get(j)) {
						guessEnemyDeck.getEnum(my_deck.sortNum.get(j)); // 누른 상대패의 값을 guessEnomyDeck으로 넘김
						guessEnemyDeck.guess(); // 다이얼로그 창뜨면서 상대덱 추측
						if (guessEnemyDeck.isRight()) { // 버튼의 숫자가 맞으면 true , 틀리면 false 리턴

							if (my_deck.sortNum.get(j) % 1 == 0.5) {

								int num = my_deck.sortNum.get(j).intValue(); // sortNum double형 어레이리스트 여서 더블형에 넣어줬다 인트형으로
																			// 변환
								my_deck.my_bt.get(j).setIcon(my_deck.card[num + 12].tail_fix);
							} else {
								int num = e_deck.sortNum.get(j).intValue();
								my_deck.my_bt.get(j).setIcon(my_deck.card[num].tail_fix);
							}
						} else {
							my_deck.my_bt.get(my_deck.my_bt.size() - 1).setContentAreaFilled(false);

						}
						turn_check = true;
						break;
					}
				}

			}
		}

	}
}
