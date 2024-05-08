package khong_su_dung_dependency_inversion;

public class Square {
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
	
	public double getPerimeter() {
		return width * 4;
	}
	
	public double getArea() {
		return width * width;
	}
	
}
