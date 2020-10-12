import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;
import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;

/* to compile this from the command line:
 * javac -cp .:jmathplot.jar:jmathio.jar ParabolaPlotter.java
 * to run it:
 * java -cp .:jmathplot.jar:jmathio.jar ParabolaPlotter
 * Replace : with ; if on Windows
 */
public class ParabolaPlotter {
	public static void main(String[] args) {
		// define your data
		double[] x = new double[21];
		double[] y = new double[21];
		// fill the data
		for (int i = -10; i <=10; i++) {
			x[i+10] = i;
			y[i+10] = i*i;
		}
		// create the plot
		Plot2DPanel plot = new Plot2DPanel();
		plot.addLinePlot("parabola",x,y);
		plot.setAxisLabels("x","y");
		plot.setFixedBounds(1, 0, 100);
		plot.addLegend("SOUTH");
		BaseLabel title = new BaseLabel("Parabola",Color.RED,0.5,1.1);
		plot.addPlotable(title);
		// create the frame the plot will reside in
		JFrame frm = new JFrame();
		frm.setTitle("A Parabola");
		frm.setBounds(100,100,500,500);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = frm.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(plot,BorderLayout.CENTER);
		frm.setVisible(true);
	}
}
