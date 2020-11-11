import java.io.Serializable;

public class Dot implements Serializable {  // model class - just holds data
	private int x;
	private int y;
	private int radius;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getRadius() {
		return radius;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setRadius(int rad) {
		if (rad <= 0) {
			radius = 1;  // a minimum radius of 3
		} else {
			radius = rad;
		}
	}
	public Dot() {
		x = 0;
		y = 0;
		radius = 1;
	}
	public Dot(int x, int y, int radius) {
		setX(x);
		setY(y);
		setRadius(radius);
	}
	/* every class in Java belongs to the same family.
	 * That family starts at java.lang.Object, the ulimate
	 * ancestor of all. java.lang.Object introduced 11
	 * functions that we inherit. One of those is
	 * public String toString(). It returns a printable
	 * String representation of the object that we can
	 * customize. For example, we could System.out.println(a dot)
	 * to see a text representation of it.
	 */
	@Override
	public String toString() {
		return String.format("%d %d %d", x, y, radius);
	}
}
