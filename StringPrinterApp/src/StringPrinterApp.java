import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class TextPanel extends JPanel {
	private String text;
	
	public String getText() {
		return text;
	}
	public void setText(String t) {
		text = t;
	}
	
	public TextPanel() {
		text = "Welcome!";
	}
	
	public TextPanel(String t) {
		setText(t);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(text, 20, 50);
	}
}
class StringPrinterFrame extends JFrame {
	public void setupLook() {
		setBounds(100,100,500,500);
		setTitle("String Printer App");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		TextPanel panCenter = new TextPanel("Man I'm tired.");
		c.add(panCenter,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JLabel lblText = new JLabel("Enter string:");
		panSouth.add(lblText);
		JTextField txtText = new JTextField(20); 
		panSouth.add(txtText);
		JLabel lblFontSize = new JLabel("Font size:");
		panSouth.add(lblFontSize);
		JTextField txtFontSize = new JTextField(2);
		panSouth.add(txtFontSize);
		c.add(panSouth,BorderLayout.SOUTH);
	}
	public StringPrinterFrame() {
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class StringPrinterApp {
	public static void main(String[] args) {
		StringPrinterFrame frm = new StringPrinterFrame();
		frm.setVisible(true);
	}
}
