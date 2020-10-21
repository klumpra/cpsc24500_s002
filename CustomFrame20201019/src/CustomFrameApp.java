import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DrawingPanel extends JPanel {
    /* A JPanel is a lightweight component.
       It renders itself using its built-in paintComponent function.
       Override the paintComponent funcion to draw on it.
       Let's see how.
    */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);     // to draw the background and borders properly - call the ancestor
                                     // super is synonym for parent
        g.drawOval(50,100,100,50);   // left top width and height within the panel
    }
}

class ButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"You clicked the button.");
	}
}

class FancyCustomFrame extends JFrame implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"You clicked the button.");		
	}
    public void setLook(String title, int left, int top, int width, int height) {
        setTitle(title);
        setBounds(left, top, width, height);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JButton btnClick = new JButton("Click Me!");
/*
 *         btnClick.addActionListener(new ActionListener() {

        	public void actionPerformed(ActionEvent e) {
//        		System.out.println("You clicked the button.");
        		JOptionPane.showMessageDialog(null, "You clicked the button");
        	}
        });
*/
/*        ButtonHandler handler = new ButtonHandler();
        btnClick.addActionListener(handler); */
        c.add(btnClick,BorderLayout.SOUTH);

        btnClick.addActionListener(this);  // this is the frame
        DrawingPanel panCenter = new DrawingPanel();
        c.add(panCenter,BorderLayout.CENTER);
    }
    public FancyCustomFrame() {  // default constructor
        setLook("Fancy Custom Frame",100,100,500,500);  // delegation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public FancyCustomFrame(String title, int left, int top, int width, int height, int closeOp) {
        setLook(title,left,top,width,height);
        setDefaultCloseOperation(closeOp);
    }
}

public class CustomFrameApp {
    public static void main(String[] args) {
        FancyCustomFrame frm = new FancyCustomFrame();
        frm.setVisible(true);
 //       FancyCustomFrame frm2 = new FancyCustomFrame("My frame", 300, 300, 500,200, JFrame.HIDE_ON_CLOSE);
 //       frm2.setVisible(true);
    }
}