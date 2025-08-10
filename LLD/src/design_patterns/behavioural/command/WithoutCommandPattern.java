package design_patterns.behavioural.command;

class TextEditor {
	public void boldText() {
		System.out.println("Text has been bolded.");
	}

	public void italicizeText() {
		System.out.println("Text has been italicized.");
	}

	public void underlineText() {
		System.out.println("Text has been underlined.");
	}
}

//UI Button Classes
class BoldButton {
	private TextEditor editor;

	public BoldButton(TextEditor editor) {
		this.editor = editor;
	}

	public void click() {
		editor.boldText();
	}
}

class ItalicButton {
	private TextEditor editor;

	public ItalicButton(TextEditor editor) {
		this.editor = editor;
	}

	public void click() {
		editor.italicizeText();
	}
}

public class WithoutCommandPattern {
	public static void main(String[] args) {
		TextEditor editor = new TextEditor();

		BoldButton boldButton = new BoldButton(editor);
		ItalicButton italicButton = new ItalicButton(editor);
		boldButton.click();
		italicButton.click();

	}
}
