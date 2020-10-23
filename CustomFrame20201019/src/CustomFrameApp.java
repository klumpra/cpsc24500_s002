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
	
	private int shapeType;   // 0 for oval, 1 for rectangle
		/* we made this private to protect access to it.
		 * the only allowed values are 0 or 1
		 * we want to keep it that way.
		 * To keep it that way, we will provide public functions that will control
		 * how the value is reported (get) and how the value is changed (set)
		 */
	
	public int getShapeType() {
		return shapeType;
	}
	
	public void setShapeType(int val) {
		if (val < 0) {
			shapeType = 0;
		} else if (val > 1) {
			shapeType = 1;
		} else {
			shapeType = val;
		}
	}
	
	public void toggleShapeType() {
		if (shapeType == 0) {
			shapeType = 1;
		} else {
			shapeType = 0;
		}
	}
	public DrawingPanel() {
		shapeType = 0;
	}
	
	public DrawingPanel(int st) {
		setShapeType(st);
	}
	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);     // to draw the background and borders properly - call the ancestor
                                     // super is synonym for parent
        if (shapeType == 0) {
        	g.drawOval(50,100,100,50);   // left top width and height within the panel
        } else if (shapeType == 1) {
        	g.drawRect(50,100,100,50);
        }
    }
}

class ButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"An external class handled this");
	}
}

class FancyCustomFrame extends JFrame /* implements ActionListener */ {
/*	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"The frame handled this.");		
	}
*/
    public void setLook(String title, int left, int top, int width, int height) {
        setTitle(title);
        setBounds(left, top, width, height);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        DrawingPanel panCenter = new DrawingPanel();
        c.add(panCenter,BorderLayout.CENTER);
        JButton btnClick = new JButton("Toggle Shape");
        btnClick.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
//        		JOptionPane.showMessageDialog(null, "An anonymous inner class handled this.");
        		// tell the panel to toggle shapeType
        		panCenter.toggleShapeType();
        		repaint();  // forces all the objects on the frame to paintComponent themselves
        	}
        });
/*
 *         ButtonHandler handler = new ButtonHandler();

           btnClick.addActionListener(handler);
*/
        
        c.add(btnClick,BorderLayout.SOUTH);

//        btnClick.addActionListener(this);  // this is the frame
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