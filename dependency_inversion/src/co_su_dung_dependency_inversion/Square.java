package co_su_dung_dependency_inversion;

public class Square implements Shape {
	private double width;
	

	public Square(double width) {
		this.width = width;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	@Override
	public double getPerimeter() {
		return width * 4;
	}
	
	@Override
	public double getArea() {
		return width * width;
	}
	
}
