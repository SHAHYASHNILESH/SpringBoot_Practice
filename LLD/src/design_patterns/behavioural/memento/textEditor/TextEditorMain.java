package design_patterns.behavioural.memento.textEditor;

public class TextEditorMain {
	public static void main(String[] args) {
		TextEditor textEditor = new TextEditor();
		CareTaker careTaker = new CareTaker(); // History // StateMgmt

		textEditor.write("Hello World!");
		careTaker.saveState(textEditor);

		textEditor.write("How are you?");
		careTaker.saveState(textEditor);

		System.out.println(textEditor.getContent());

		// Problem - > Undo the last write!
		careTaker.undo(textEditor);
		
		System.out.println(textEditor.getContent());
	}
}
