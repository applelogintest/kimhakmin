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

public class Dummy extends JPanel {

	CardVO[] card = new CardVO[24];
	JButton[] bt = new JButton[24];
	JPanel m_panel = new JPanel();
	JPanel e_panel = new JPanel();
	int[] su = new int[24];
	

	public Dummy() {

		setLayout(null);

		setBackground(new Color(0, 0, 255, 255));
		boolean bCheck = false;

		for (int i = 0; i < 24; i++) // �� ȭ��Ʈ ī�� �޸� ����
		{
			card[i] = new CardVO(); // ��ü �ʱ�ȭ
			if (i < 12) {
				card[i].tail_back = new ImageIcon(("C:\\Davinci_code\\Project\\Img\\tile\\b_tile_back.png"));
			} else {
				card[i].tail_back = new ImageIcon(("C:\\Davinci_code\\Project\\Img\\tile\\w_tile_back.png"));

			}

			card[i].img = card[i].tail_back.getImage();
			card[i].fix_img = card[i].img.getScaledInstance(220, 190, Image.SCALE_SMOOTH);
			card[i].tail_back_fix = new ImageIcon(card[i].fix_img);

		}

		for (int i = 0; i < 24; i++) { // �� ȭ��Ʈ ī�� �ո� ����

			if (i < 12) {
				card[i].tail = new ImageIcon(("C:\\Davinci_code\\Project\\Img\\tile\\b_tile_" + i + ".png"));

			} else {
				card[i].tail = new ImageIcon(("C:\\Davinci_code\\Project\\Img\\tile\\w_tile_" + (i - 12) + ".png"));

			}

			card[i].img = card[i].tail.getImage();
			card[i].fix_img = card[i].img.getScaledInstance(220, 190, Image.SCALE_SMOOTH);
			card[i].tail_fix = new ImageIcon(card[i].fix_img);

		}

		for (int i = 0; i < 24; i++) // ���� ���� �̿��Ͽ� ��ư�� �������� �迭
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
			bt[i].setPreferredSize(new Dimension(60, 100));
			p.add(bt[i]);

		}
		
		System.out.println("ī��  4���� �����ϼ���");
		p.setBounds(100, 350, 800, 210);
		m_panel.setBounds(100, 750, 800, 110); // �ڽ��� �� �г� ũ�� ����
		e_panel.setBounds(100, 50,800,110);
		add(p);
		add(m_panel);
		add(e_panel);

	}

}
