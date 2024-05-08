package khong_su_dung_dependency_inversion;

public class Rectangle {
	private double width;
	private double length;
	
	public Rectangle(double i, double j) {
		width = i;
		length = j;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	
	public double getPerimeter() {
		return (width + length) * 2;
	}
	
	public double getArea() {
		return width * length;
	}
}
