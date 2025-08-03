package design_patterns.behavioural.memento.textEditor;

public class TextEditor {

	private String content;

	public void write(String content) {
		this.content = content;
	}

	// Save the current state of editor
	public EditorMemento save() {
		return new EditorMemento(this.content);
	}

	// Restore (Memento->update the state of current content)
	public void restore(EditorMemento memento) {
		content = memento.getContent();
	}

	public String getContent() {
		return this.content;
	}
}
