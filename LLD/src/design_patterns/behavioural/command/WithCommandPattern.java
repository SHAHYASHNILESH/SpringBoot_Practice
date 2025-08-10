package design_patterns.behavioural.command;

//Command Interface
interface Command {
	void execute();
}

//Concrete Classes for Commands
class BoldCommand implements Command {
	private TextEditorII editor;

	public BoldCommand(TextEditorII editor) {
		this.editor = editor;
	}

	@Override
	public void execute() {
		editor.boldText();
	}
}

class ChangeColor implements Command {
	private TextEditorII editor;

	public ChangeColor(TextEditorII editor) {
		this.editor = editor;
	}

	@Override
	public void execute() {
		editor.changeColor();
	}
}

//Button Class
class Button {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void click() {
		command.execute();
	}
}

//Receiver: TextEditor class
class TextEditorII {
	public void boldText() {
		System.out.println("Text has been bolded.");
	}

	public void italicizeText() {
		System.out.println("Text has been italicized.");
	}

	public void underlineText() {
		System.out.println("Text has been underlined.");
	}

	public void changeColor() {
		System.out.println("Text color has been changed");
	}
}

public class WithCommandPattern {
	public static void main(String[] args) {
		TextEditorII editorII = new TextEditorII();

		// Button Decoupling -> One button can do many types of actions, decoupled from the text editor
		Button button = new Button();
		button.setCommand(new BoldCommand(editorII));
		button.click();

		button.setCommand(new ChangeColor(editorII));
		button.click();

	}
}