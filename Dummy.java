import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dummy extends JPanel implements ActionListener {
	JFrame f = new JFrame();
	 ArrayList<ImageIcon> tail_back = new ArrayList<ImageIcon>();
	 ArrayList<ImageIcon> tail_back_fix = new ArrayList<ImageIcon>();
	 ArrayList<ImageIcon> tail = new ArrayList<ImageIcon>();
	 ArrayList<ImageIcon> tail_fix = new ArrayList<ImageIcon>();
	 JButton[] bt = new JButton[24];
	Image img, fix_img;
	// JPanel p;

	public Dummy() {

		f.setLayout(null);

		// p = new JPanel();

		int space = 70;
		int space2 = 70;
		int su[] = new int[24];

		boolean bCheck = false;

		for (int i = 0; i < bt.length; i++) {

			if (i < 12)
				tail_back.add(new ImageIcon(("C:\\Davinci_code\\Project\\Img\\tile\\b_tile_back.png")));
			else
				tail_back.add(new ImageIcon(("C:\\Davinci_code\\Project\\Img\\tile\\w_tile_back.png")));

			img = tail_back.get(i).getImage();
			fix_img = img.getScaledInstance(220, 190, Image.SCALE_SMOOTH);
			tail_back_fix.add(new ImageIcon(fix_img));

		}

		for (int i = 0; i < bt.length; i++) {

			if (i < 12)
				tail.add(new ImageIcon(("C:\\Davinci_code\\Project\\Img\\tile\\b_tile_" + i + ".png")));
			else
				tail.add(new ImageIcon(("C:\\Davinci_code\\Project\\Img\\tile\\w_tile_" + (i - 12) + ".png")));

			img = tail.get(i).getImage();
			fix_img = img.getScaledInstance(220, 190, Image.SCALE_SMOOTH);
			tail_fix.add(new ImageIcon(fix_img));

		}

		for (int i = 0; i < bt.length; i++) {
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

			bt[su[i]] = new JButton(tail_back_fix.get(su[i]));

			if (i == 0) {

				bt[su[i]].setBounds(50, 190, 60, 100);

			} else if (i > 0 && i < 12) {

				bt[su[i]].setBounds(50 + space, 190, 60, 100);
				space += 70;

			} else if (i == 12) {
				bt[su[i]].setBounds(50, 300, 60, 100);

			} else if (i > 12) {
				bt[su[i]].setBounds(50 + space2, 300, 60, 100);
				space2 += 70;
			}

		}

		// bt[5] = new JButton("null");

		for (JButton a : bt) {
			a.addActionListener(this);
			f.add(a);
		}

		f.setSize(1024, 1024);
		f.setVisible(true);

		// add(p);

	}

	@Override public void actionPerformed(ActionEvent e) { 
		
	   for (int i = 0; i < 24; i++) {
		   if (e.getSource() == bt[i]) {
			   bt[i].setVisible(false);
			   System.out.println(i); 
			   break;
		   	}
		 }
	}

}
