import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener {
	// this is a View class
	private String mouseStatus;
	private ArrayList<Dot> dots;
	private int dotSize;
	public void clearDots() {
		dots.clear();
	}
	public int getDotSize() {
		return dotSize;
	}
	public void setDotSize(int ds) {
		if (ds <= 0) {
			dotSize = 1;
		} else {
			dotSize = ds;
		}
	}
	public ArrayList<Dot> getDots() {
		return dots;
	}
	public void setDots(ArrayList<Dot> listOfDots) {
		dots = listOfDots;
	}
	public DrawingPanel() {
		mouseStatus = "Welcome!";
		addMouseListener(this);
		addMouseMotionListener(this);
		dots = new ArrayList<Dot>(); // avoid nullpointerexceptions
		dotSize = 20;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(mouseStatus, 20, 20);
		for (Dot dot : dots) {
			g.fillOval(dot.getX(),dot.getY(),dot.getRadius(),dot.getRadius());
		}
	}
	public String getMouseStatus() {
		return mouseStatus;
	}
	public void setMouseStatus(String ms) {
		mouseStatus = ms;
	}
	public void mouseEntered(MouseEvent e) { 
		mouseStatus = "Entered the window.";
		repaint();
	}
	public void mouseExited(MouseEvent e) {
		mouseStatus = "Exited the window.";
		repaint();
	}
	public void mousePressed(MouseEvent e) {
		mouseStatus = String.format("Mouse pressed at (%d, %d)", e.getX(), e.getY());
		repaint();
	}
	public void mouseReleased(MouseEvent e) {
		mouseStatus = String.format("Mouse released at (%d, %d)", e.getX(), e.getY());
		repaint();
	}
	public void mouseClicked(MouseEvent e) { 
		mouseStatus = String.format("Mouse clicked at (%d, %d)", e.getX(), e.getY());
		repaint();
	}
	public void mouseMoved(MouseEvent e) { 
		mouseStatus = String.format("Mouse moved at (%d, %d)", e.getX(), e.getY());
		repaint();
		
	}
	public void mouseDragged(MouseEvent e) { 
		mouseStatus = String.format("Mouse dragged at (%d, %d)", e.getX(), e.getY());
		Dot dotty = new Dot(e.getX(),e.getY(),dotSize);
		dots.add(dotty);
		repaint();
	}

}
