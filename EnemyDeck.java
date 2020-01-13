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
			my_bt.add(new JButton()); // �ڽ��� �� �ʱ�ȭ
		}

		e_panel = dummy.e_panel;

	}

	public JButton selected_card(double num, int bt_index) { // my���� ���� �̹��� �ϳ��� ����

		if (num % 1 == 0.5) { // �� Ÿ������ Ȯ��

			my_bt.get(bt_index).setIcon(card[(int) num + 12].tail_back_fix);
			my_bt.get(bt_index).setPreferredSize(new Dimension(60, 100));

		} else {
			my_bt.get(bt_index).setIcon(card[((int) num)].tail_back_fix);
			my_bt.get(bt_index).setPreferredSize(new Dimension(60, 100));
		}

		return my_bt.get(bt_index);
	}

	public void mydeck_choice(int i) { // dummy���� ī�带 ���� ���� �� ��� �����Ͽ� sortNum�� ������ ���Ľ�Ų��
		if (card[i].card_num > 11) { // ��� ������ ���������Ѽ� ������� �����ϱ����� ���� 0.5�� ū���� �־���
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
