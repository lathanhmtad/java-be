package khong_su_dung_dependency_inversion;

public class Main {
	public static void main(String[] args) {
		ShapeManager shapeManager = new ShapeManager();
		
		shapeManager.setCircle(new Circle(5));
		shapeManager.setRectangle(new Rectangle(5, 6));
		shapeManager.setSquare(new Square(5));

		System.out.println("Circle with perimeter and area: " + shapeManager.getPerimeterCircle() + " : "
				+ shapeManager.getAreaCircle());
		
		System.out.println("Square with perimeter and area: " + shapeManager.getPerimeterSquare() + " : "
				+ shapeManager.getAreaSquare());
	}
}
