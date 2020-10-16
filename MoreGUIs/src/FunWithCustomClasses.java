import javax.swing.JFrame;

/**
 * Every class so far that we've created has had a public static void main.
 * This is the runnable part of our application.
 * Most classes, however, are not meant to be run - they are meant to be used.
 * Such classes don't have public static void mains.
 * Most of these classes have few or no static functions in them.
 * (aside - because main is static, any function you called from main had to be static.)
 * Most classes have no static functions.
 * This application will provide our first example of creating our own classes that
 * aren't meant to be run - they are meant to be used.
 * 
 * The class definition is the prototype - the instructions for building something.
 * The variables - the objects - are built according to the instructions.
 * 
 * Classes give us the opportunity to reuse functionality across many applications.
 * Classes also reduce redundancy
 * 
 * @author klumpra
 *
 */
public class FunWithCustomClasses {
	public static void main(String[] args) {
		MyCustomFrame frm = new MyCustomFrame();
		frm.setVisible(true);
		MyCustomFrame frm2 = new MyCustomFrame("A Customized Frame", 200,300,700,400,JFrame.HIDE_ON_CLOSE);
		frm2.setVisible(true);
	}

}
