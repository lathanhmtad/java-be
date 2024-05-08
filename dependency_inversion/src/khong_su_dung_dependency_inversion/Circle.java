package khong_su_dung_dependency_inversion;

public class Circle {
	private double r;

	public Circle(double r) {
		super();
		this.r = r;
	}

	public double getPerimeter() {
		return 2 * Math.PI * r;
	}

	public double getArea() {
		return Math.PI * r * r;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

}
