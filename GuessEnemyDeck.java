import javax.swing.JOptionPane;
import java.util.*;

public class GuessEnemyDeck extends JOptionPane{
	JOptionPane jp = new JOptionPane();
	double e_num =0.0; 
	double guess_num;
	String[] buttons = {"0","1", "2", "3","4","5","6","7","8","9","10","11"};
	
	public void getEnum(double e_num) {
		this.e_num = e_num;
	}
	
	public void guess() { // ���̾�α� â ���� ������ư�� �� ����
		guess_num = jp.showOptionDialog(null, "����и� �����غ�����", "null",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "");
	}
	
	public boolean isRight() {
		if(e_num % 1 == 0.5) {
			guess_num -= 0.5;
		}
		if(e_num == guess_num)
			return true;
		else
			return false;
		
	}
	
}
