package design_patterns.behavioural.memento.graphicEditor;

public class GraphicEditor {

	private String shapeType;
	private int x;
	private int y;
	private String color;
	private int size;

	public EditorMemento save() {
		// TODO: Create and return a new memento that captures the current state of the
		// shape attributes.
		return new EditorMemento(shapeType, x, y, color, size);
	}

	public void restore(EditorMemento memento) {
		// TODO: Restore the shape attributes from the provided memento, updating the
		// graphic editor's state.
		shapeType = memento.getShapeType();
		x = memento.getX();
		y = memento.getY();
		color = memento.getColor();
		size = memento.getSize();
	}

	public String getShape() {
		return "Shape: " + shapeType + ", Position: (" + x + ", " + y + "), Color: " + color + ", Size: " + size;
	}

	public void setShape(String shapeType, int x, int y, String color, int size) {
		this.shapeType = shapeType;
		this.x = x;
		this.y = y;
		this.color = color;
		this.size = size;
	}
}
