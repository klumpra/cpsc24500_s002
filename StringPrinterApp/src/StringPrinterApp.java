import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class TextPanel extends JPanel {
	private String text;
//	private int fontSize;
	private Font font;	

	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public String getText() {
		return text;
	}
	public void setText(String t) {
		text = t;
	}
	public void setFont(int fs) {
		if (fs < 6) {
			font = new Font("Arial", Font.PLAIN, 12);
		} else {
			font = new Font("Arial", Font.PLAIN, fs);
		}
	}
	public TextPanel() {
		text = "Welcome!";
		setFont(14);
	}
	
	public TextPanel(String t, int fs) {
		setText(t);
		setFont(fs);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(font);
		g.drawString(text, 20, 50);
	}
}
class StringPrinterFrame extends JFrame {
	public void setupLook() {
		setBounds(100,100,500,500);
		setTitle("String Printer App");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		TextPanel panCenter = new TextPanel("Man I'm tired.",14);
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
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panCenter.setText(txtText.getText());
				try {
					int fontSize = Integer.parseInt(txtFontSize.getText());
					panCenter.setFont(fontSize);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"The font size must be an integer.");
				}
				repaint(); // repaints the entire window's contents. For example, 
						//panCenter will be repainted --> paintComponent for TextPanel
						//will be automatically called.
			}
		}	
		);
		panSouth.add(btnChange);
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
