package design_patterns.creational.abstract_factory;

//Windows UI Components

class WindowsButton1 {
	public void render() {
		System.out.println("Rendering windows button");
	}
}

class WindowsScrollBar1 {
	public void render() {
		System.out.println("Rendering windows scrollbar");
	}
}

//Mac UI components
class MacOSButton1 {
	public void render() {
		System.out.println("Rendering MacOS button");
	}
}

class MacOSScrollBar1 {
	public void render() {
		System.out.println("Rendering MacOS scrollbar");
	}
}

public class ApplicationWithoutAbstractFactory {
	public static void main(String[] args) {
		// Windows UI
		WindowsButton1 button = new WindowsButton1();
		WindowsScrollBar1 scrollBar = new WindowsScrollBar1();

		// Mac UI
		button.render();
		scrollBar.render();
	}
}