package design_patterns.creational.abstract_factory;

//Abstract Product Interfaces
interface Button {
	void render();
}

interface ScrollBar {
	void scroll();
}

//Windows UI Components
class WindowsButton implements Button {
	public void render() {
		System.out.println("Rendering windows button");
	}
}

class WindowsScrollBar implements ScrollBar {
	public void scroll() {
		System.out.println("Scrolling windows scrollbar");
	}
}

//Mac UI components
class MacOSButton implements Button {
	public void render() {
		System.out.println("Rendering MacOS button");
	}
}

class MacOSScrollBar implements ScrollBar {
	public void scroll() {
		System.out.println("Scrolling MacOs scrollbar");
	}
}

//Abstract Factory Interface
interface UIFactory {
	Button createButton();

	ScrollBar createScrollBar();
}

//Concrete Implementation
class WindowsFactory implements UIFactory {

	@Override
	public Button createButton() {
		return new WindowsButton();
	}

	@Override
	public ScrollBar createScrollBar() {
		return new WindowsScrollBar();
	}
}

class MacOSFactory implements UIFactory {

	@Override
	public Button createButton() {
		return new MacOSButton();
	}

	@Override
	public ScrollBar createScrollBar() {
		return new MacOSScrollBar();
	}
}

public class Application {
	private Button button;
	private ScrollBar scrollBar;

	public Application(UIFactory factory) {
		this.button = factory.createButton();
		this.scrollBar = factory.createScrollBar();
	}

	public void renderUI() {
		button.render();
		scrollBar.scroll();
	}

	public static void main(String[] args) {
		// Use Windows UI
		UIFactory windowsFactory = new WindowsFactory();
		Application app = new Application(windowsFactory);
		app.renderUI();
	}
}
