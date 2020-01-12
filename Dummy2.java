import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Dummy2 extends JPanel implements ActionListener {

	boolean bCheck = false;
	CardVO[] card = new CardVO[24];
	JButton[] bt = new JButton[24];
	ArrayList<JButton> my_bt = new ArrayList<JButton>();
	ArrayList<Double> sortNum = new ArrayList<Double>();
	JPanel m_panel = new JPanel();
	int k = 0;
	int color_check = 0;

	int[] su = new int[24];

	public Dummy2() {

		setLayout(null);

		setBackground(new Color(0, 0, 255, 255));
		boolean bCheck = false;

		for (int i = 0; i < 24; i++) // 블랙 화이트 카드 뒷면 저장
		{
			card[i] = new CardVO(); // 객체 초기화
			my_bt.add(new JButton()); // 자신의덱 버튼 초기화

			if (i < 12) {
				card[i].tail_back = new ImageIcon(("C:\\Davinci_code\\Project\\Img\\tile\\b_tile_back.png"));
			} else {
				card[i].tail_back = new ImageIcon(("C:\\Davinci_code\\Project\\Img\\tile\\w_tile_back.png"));

			}

			card[i].img = card[i].tail_back.getImage();
			card[i].fix_img = card[i].img.getScaledInstance(220, 190, Image.SCALE_SMOOTH);
			card[i].tail_back_fix = new ImageIcon(card[i].fix_img);

		}

		for (int i = 0; i < 24; i++) { // 블랙 화이트 카드 앞면 저장

			if (i < 12) {
				card[i].tail = new ImageIcon(("C:\\Davinci_code\\Project\\Img\\tile\\b_tile_" + i + ".png"));

			} else {
				card[i].tail = new ImageIcon(("C:\\Davinci_code\\Project\\Img\\tile\\w_tile_" + (i - 12) + ".png"));

			}

			card[i].img = card[i].tail.getImage();
			card[i].fix_img = card[i].img.getScaledInstance(220, 190, Image.SCALE_SMOOTH);
			card[i].tail_fix = new ImageIcon(card[i].fix_img);

		}

		for (int i = 0; i < 24; i++) // 랜덤 수를 이용하여 버튼을 랜덤으로 배열
		{
			bCheck = true;
			while (bCheck) {
				bCheck = false;
				int rand = (int) (Math.random() * 24);
				for (int j = 0; j < i; j++) {

					if (su[j] == rand) {

						bCheck = true;
						break;
					}
				}

				su[i] = rand;
			}

			bt[i] = new JButton(card[su[i]].tail_fix);
			card[i].card_num = su[i];
		}

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 1, 10, 10));

		for (int i = 0; i < bt.length; i++) {
			bt[i].addActionListener(this);
			bt[i].setPreferredSize(new Dimension(60, 100));

			p.add(bt[i]);

		}

		p.setBounds(100, 350, 800, 210);
		m_panel.setBounds(100, 750, 800, 110); // 자신의 덱 패널 크기 조절

		add(p);
		add(m_panel);

	}

	public JButton myDeck(double num, int bt_index) {
		
		if(num % 1 == 0.5)
		{
			my_bt.get(bt_index).setIcon(card[(int)num+12].tail_fix);
			my_bt.get(bt_index).setPreferredSize(new Dimension(60, 100));
		}
		else
		{
			my_bt.get(bt_index).setIcon(card[((int)num)].tail_fix);
			my_bt.get(bt_index).setPreferredSize(new Dimension(60, 100));
		}
			
		return my_bt.get(bt_index);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 24; i++) {
			if (e.getSource() == bt[i]) {
				if(card[i].card_num > 11) { //흑백 구분후 정열을시켜서 순서대로 나열하기위해 백은 0.5더 큰값을 주었다
					System.out.println(card[i].card_num);
					sortNum.add(card[i].card_num - 11.5);
					System.out.println(sortNum.get(k));
				}
				else {
					//System.out.println(card[i].card_num);
					sortNum.add((double)card[i].card_num);
				}
				
				if (k == 0) {
					m_panel.add(myDeck(sortNum.get(k), 0));
					k++;
					bt[i].setVisible(false);

				} else {

					Collections.sort(sortNum);
					System.out.println(sortNum);
					for (int z = 0; z <= k; z++) {
						m_panel.add(myDeck(sortNum.get(z), z));
					}

					k++;

					bt[i].setVisible(false);
				}
				break;
			}

		}

	}

}
