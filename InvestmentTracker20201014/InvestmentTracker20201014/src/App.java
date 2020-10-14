import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;

import javax.swing.JFrame;

import org.math.plot.Plot2DPanel;

import java.awt.Container;
import java.awt.BorderLayout;

public class App {
    public static LinkedHashMap<String,double[]> readData(Scanner fsc) {
        LinkedHashMap<String,double[]> result = new LinkedHashMap<String,double[]>();
        fsc.nextLine();  // gets rid of the first line
        String name; // name of person
        String line; // line that we read
        String[] parts;
        double[] values;  // the investment values
        while (fsc.hasNextLine()) {
            line = fsc.nextLine();
            parts = line.split("\t");
            name = parts[0];
            values = new double[parts.length-1];
            // fill the values with the investment totals
            for (int i = 1; i < parts.length; i++) {
                values[i-1] = Double.parseDouble(parts[i]);
            }
            // now I have the name and the investment totals
            // put them in the result map
            result.put(name,values);
        }
        // all the accounts info will now be returned.
        return result;
    }
    // used to generate day numbers for the x axis of our plots
    public static double[] getDays(int howMany) {
        double[] result = new double[howMany];
        for (int i = 0; i < howMany; i++) {
            result[i] = i;
        }
        return result;
    }
    public static void setUpAndShowPlot(Plot2DPanel plot) {
        JFrame frm = new JFrame();
        frm.setBounds(100,100,500,500);
        frm.setTitle("Investment Curves");
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // get rid from memory
        Container c = frm.getContentPane();
        c.setLayout(new BorderLayout());
        plot.addLegend("SOUTH");
        plot.setAxisLabels("Day","Value");
        c.add(plot,BorderLayout.CENTER);
        frm.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        LinkedHashMap<String,double[]> accounts;
        String inputtedNames;
        String[] names;
        Scanner sc = new Scanner(System.in);
        double[] investmentValues;
        try {
            Scanner fsc = new Scanner(new File("investments.txt"));
            accounts = readData(fsc);
        } catch (Exception ex) {
            accounts = null;  // I wasn't able to read the data
        }
        if (accounts == null) {
            System.out.println("Couldn't read the file.");
        } else {
            // repeatedly ask the user for the names of people for whom
            // they want to see the investment curves
            do {
                System.out.print("Enter name of people separated by commas: ");
                inputtedNames = sc.nextLine();
                if (!inputtedNames.equalsIgnoreCase("exit")) {
                    // plot is where the data will be shown
                    Plot2DPanel plot = new Plot2DPanel();
                    // try to plot the data
                    names = inputtedNames.split(",");
                    for (String name : names) {
                        name = name.trim(); // remove any leading space
                        if (!accounts.containsKey(name)) {
                            System.out.printf("%s is not in the data.\n", name);
                        } else {
                            investmentValues = accounts.get(name); // this person's investment values
                            plot.addLinePlot(name, getDays(investmentValues.length), investmentValues);
                        }
                    }
                    // configure and show the frame that houses the plot
                    setUpAndShowPlot(plot);
                }
            } while (!inputtedNames.equalsIgnoreCase("exit"));
            System.out.println("Thank you");
        }
    }
}
