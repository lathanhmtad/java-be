package quickstart;

import javax.inject.Inject;

public class ShapeService {
	@Inject
	IShape shape; 
	
	public String find() {
		return shape.getName();
	}
}
