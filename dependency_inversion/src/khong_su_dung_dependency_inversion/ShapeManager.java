package khong_su_dung_dependency_inversion;

public class ShapeManager {
	private Circle circle;
	private Rectangle rectangle;
	private Square square;
	
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Rectangle getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	public Square getSquare() {
		return square;
	}
	public void setSquare(Square square) {
		this.square = square;
	}
	
	public double getPerimeterCircle() {
		return circle.getPerimeter();
	}
	
	public double getPerimeterRectangle() {
		return rectangle.getPerimeter();
	}
	
	public double getPerimeterSquare() {
		return square.getPerimeter();
	}
	
	public double getAreaCircle() {
		return circle.getArea();
	}
	
	public double getAreaRectangle() {
		return rectangle.getArea();
	}
	
	public double getAreaSquare() {
		return square.getArea();
	}
	
}
