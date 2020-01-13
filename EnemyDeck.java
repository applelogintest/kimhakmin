import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EnemyDeck {
	JPanel e_panel = new JPanel();
	ArrayList<JButton> my_bt = new ArrayList<JButton>();
	ArrayList<Double> sortNum = new ArrayList<Double>();
	JButton[] bt = new JButton[24];
	CardVO[] card = new CardVO[24];

	int k = 0;

	public EnemyDeck(Dummy dummy) {

		for (int i = 0; i < 24; i++) {
			card[i] = dummy.card[i];
			bt[i] = dummy.bt[i];
		}

		for (int i = 0; i < 12; i++) {
			my_bt.add(new JButton()); // 자신의 덱 초기화
		}

		e_panel = dummy.e_panel;

	}

	public JButton selected_card(double num, int bt_index) { // my덱에 넣을 이미지 하나씩 리턴

		if (num % 1 == 0.5) { // 백 타일인지 확인

			my_bt.get(bt_index).setIcon(card[(int) num + 12].tail_back_fix);
			my_bt.get(bt_index).setPreferredSize(new Dimension(60, 100));

		} else {
			my_bt.get(bt_index).setIcon(card[((int) num)].tail_back_fix);
			my_bt.get(bt_index).setPreferredSize(new Dimension(60, 100));
		}

		return my_bt.get(bt_index);
	}

	public void mydeck_choice(int i) { // dummy에서 카드를 고르면 숫자 및 흑백 구분하여 sortNum에 저장후 정렬시킨다
		if (card[i].card_num > 11) { // 흑백 구분후 정열을시켜서 순서대로 나열하기위해 백은 0.5더 큰값을 주었다
			sortNum.add(card[i].card_num - 11.5);
		} else {
			sortNum.add((double) card[i].card_num);
		}

		if (k == 0) {
			e_panel.add(selected_card(sortNum.get(k), 0));
			k++;
			bt[i].setVisible(false);

		} else {

			Collections.sort(sortNum);
			for (int z = 0; z <= k; z++) {
				e_panel.add(selected_card(sortNum.get(z), z));
			}

			k++;

			bt[i].setVisible(false);
		}

	}


}
