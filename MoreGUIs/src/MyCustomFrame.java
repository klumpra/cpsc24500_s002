import javax.swing.JFrame;

/**
 * MyCustomFrame "is a" JFrame. That's what "extends" literally means.
 * As such, it can occupy screen real estate.
 * It has all the bells and whistles that JFrame introduces.
 * But it can put its own spin on those things.
 * @author klumpra
 *
 */
public class MyCustomFrame extends JFrame {
	/* To customize one class so that it differs from its ancestor,
	 * we use constructors. Constructors are functions that don't
	 * have a return type and have the same name as the name of the class.
	 * They set aside enough memory, and they initialize the data
	 * that needs to be initialized to create an object.
	 * Ex: You are an object of the Human class.
	 * As such, you have eyeColor and hairColor - those are data members
	 * The constructor that was used to build you took in values for these.
	 * For JFrames, you might want to set title, left, top, width, height, default close op
	 */
	/* there are two types of constructors: default and non-default.
	 * default constructors take in no params and set the data to default values
	 * non-default constructors take in params and use them to set the data members' values
	 * Both types have the same name as the name of the class.
	 * You can have two functions with the same name - function overloading
	 * This is allowed if the two functions differ in the order, type, and/or number of 
	 * their parameters (name-mangling)
	 */
	/**
	 * here is the default constructor
	 */
	public MyCustomFrame() {
		this("Default Frame", 100, 100, 500, 500, JFrame.EXIT_ON_CLOSE);  /*
			this(...) calls another of the class's constructors, passing it
			the things it needs
		*/
	}
	/**
	 * here is a non-default constructor. This takes in the title, bounds, and close operation
	 */
	public MyCustomFrame(String title, int left, int top, int width, int height, int closeOp) {
		setLook(title,left,top,width,height);
		setDefaultCloseOperation(closeOp);
	}
	public void setLook(String title, int left, int top, int width, int height) {
		setTitle(title);
		setBounds(left,top,width,height);
	}
}
