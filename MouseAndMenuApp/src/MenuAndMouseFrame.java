import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuAndMouseFrame extends JFrame {
	private DrawingPanel pan;
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miSave = new JMenuItem("Save");
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				DotWriter dw;
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					dw = new DotWriter();
					if (dw.write(jfc.getSelectedFile(),pan.getDots())) {
						JOptionPane.showMessageDialog(null,"Dots were written.");
					} else {
						JOptionPane.showMessageDialog(null,"Dots could not be written.");
					}
				}
			}
		});
		mnuFile.add(miSave);
		JMenuItem miLoad = new JMenuItem("Load");
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				DotReader dr;
				ArrayList<Dot> dotsRead;
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					dr = new DotReader();
					dotsRead = dr.read(jfc.getSelectedFile());
					if (dotsRead == null) {
						JOptionPane.showMessageDialog(null,"Could not read.");
					} else {
						pan.setDots(dotsRead);
						repaint();
					}
				}
			}
		});
		mnuFile.add(miLoad);
		JMenuItem miClear = new JMenuItem("Clear");
		miClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pan.setMouseStatus("");
				pan.clearDots();
				repaint();
			}
		});
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnuFile.add(miClear);
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		JMenu mnuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Application created by me!");
			}
		});
		mnuHelp.add(miAbout);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
	}
	public void setupLook() {
		setBounds(100,100,500,500);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		pan = new DrawingPanel();
		c.add(pan,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		panSouth.add(new JLabel("Size"));
		JTextField txtSize = new JTextField(2);
		panSouth.add(txtSize);
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ds = Integer.parseInt(txtSize.getText());
					pan.setDotSize(ds);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"The size must be an int.");
				}
			}
		});
		panSouth.add(btnChange);
		c.add(panSouth,BorderLayout.SOUTH);
		setupMenu();
	}
	public MenuAndMouseFrame() {
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
