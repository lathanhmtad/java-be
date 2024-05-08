package co_su_dung_dependency_inversion;

public class ShapeManager {
	
	private Shape shape;    
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	
	public double calculatePerimeter() {
		return shape.getPerimeter();
	}
	
	public double calculateArea() {
		return shape.getArea();
	}
}
