package co_su_dung_dependency_inversion;

public class Rectangle implements Shape{
	private double width;
	private double length;
	
	
	public Rectangle(double width, double length) {
		super();
		this.width = width;
		this.length = length;
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
	
	@Override
	public double getPerimeter() {
		return (width + length) * 2;
	}
	
	@Override
	public double getArea() {
		return width * length;
	}
}
