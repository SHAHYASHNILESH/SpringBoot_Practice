package design_patterns.behavioural.memento.graphicEditor;

import java.util.Scanner;

public class Exercise {

	// Do not modify the run method. It is designed to gather user input and manage
	// shape states.
	public void run() {

		Scanner sc = new Scanner(System.in);
		GraphicEditor graphicEditor = new GraphicEditor();
		Caretaker caretaker = new Caretaker();

		for (int i = 0; i < 3; i++) {
			String shape = sc.next();
			int x = sc.nextInt();
			int y = sc.nextInt();
			String color = sc.next();
			int size = sc.nextInt();

			// TODO: Update the graphic editor with the new shape attributes from user
			// input.
			graphicEditor.setShape(shape, x, y, color, size);

			// TODO: Save the current state of the graphic editor to the history
			caretaker.saveState(graphicEditor);

		}

		sc.close();

		// TODO: Implement the undo operation to revert to the previous shape state
		caretaker.undo(graphicEditor);

		// TODO: Output the current shape attributes after the undo operation to verify
		// the restored state.
		System.out.println(graphicEditor.getShape());

	}
}
