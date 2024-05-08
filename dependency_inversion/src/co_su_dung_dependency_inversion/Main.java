package co_su_dung_dependency_inversion;

public class Main {
	public static void main(String[] args) {
		Shape circle = new Circle(5);
        Shape square = new Square(5);
        Shape rectangle = new Rectangle(4, 6);
		
		ShapeManager shapeManager = new ShapeManager();
		
		shapeManager.setShape(circle);
		System.out.println("Circle with perimeter and area: " + shapeManager.calculatePerimeter() + " : "
				+ shapeManager.calculateArea());
		
		shapeManager.setShape(square);
		System.out.println("Square with perimeter and area: " + shapeManager.calculatePerimeter() + " : "
				+ shapeManager.calculateArea());
		
		shapeManager.setShape(rectangle);
		System.out.println("Rectangle with perimeter and area: " + shapeManager.calculatePerimeter() + " : "
				+ shapeManager.calculateArea());
	}
}
