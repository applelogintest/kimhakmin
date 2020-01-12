import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CardButton extends JButton{
	int num;
	ImageIcon image,back_image;
	boolean check;
	
	public CardButton(String str, int n, ImageIcon image, ImageIcon back) {
		super(str,back);
		this.image = image;
		back_image = back;
		num = n;
		check = true;
	}
	
	public int clickButton() {
		if(check)
		{
			setIcon(image);
			check = false;
			return num;
		}
		return -1;
	}
	
	public void ChageImage(ImageIcon image, int n)
	{
		this.image = image;
		num = n;
	}
	

}
