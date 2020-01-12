import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameHandler extends JPanel implements ActionListener{
	//MyDeck md = new MyDeck();
	public GameHandler() {
		for(int i=0; i<24; i++) {
			Dummy.bt[i].addActionListener(this);
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 24; i++) {
			if (e.getSource() == Dummy.bt[i]) {
				Dummy.bt[i].setVisible(false);
				/* System.out.println(i); */
				//md.myDeck.add(Dummy.bt[i]);
				
				break;

			}
		}
		
		
	}

}
