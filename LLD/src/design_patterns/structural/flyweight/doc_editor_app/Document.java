package design_patterns.structural.flyweight.doc_editor_app;

public class Document {
    private final StringBuilder content = new StringBuilder();
    private final CharacterFactory characterFactory = new CharacterFactory();

    public void addCharacter(String character, String fontStyle, int fontSize, String color) {
        CharacterFlyweight characterFlyweight = characterFactory.getCharacter(fontStyle, fontSize, color);

        // TODO: Append the character to the document's content.
        content.append(character);

        // TODO: Display the character's attributes using the CharacterFlyweight instance.
        characterFlyweight.display(character);

    }

    public void render() {
        System.out.println("Document Content: " + content.toString());
    }
}
