package co_su_dung_dependency_inversion;

public class Circle implements Shape {
	private double r;

	public Circle(double r) {
		this.r = r;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * r;
	}

	@Override
	public double getArea() {
		return Math.PI * r * r;
	}

}
