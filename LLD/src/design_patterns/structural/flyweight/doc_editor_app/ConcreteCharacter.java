package design_patterns.structural.flyweight.doc_editor_app;

public class ConcreteCharacter implements CharacterFlyweight {
    private final String fontStyle;
    private final int fontSize;
    private final String color;

    public ConcreteCharacter(String fontStyle, int fontSize, String color) {
        this.fontStyle = fontStyle;
        this.fontSize = fontSize;
        this.color = color;
    }

    @Override
    public void display(String character) {
        System.out.printf("Character: %s, Font Style: %s, Font Size: %d, Color: %s%n",
                character, fontStyle, fontSize, color);
    }
}
