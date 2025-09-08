package design_patterns.structural.flyweight.solution;

//Flyweight Class
public class BulletType {
    private String color; //Intrinsic Property

    public BulletType(String color) {
        this.color = color;
        System.out.println("Creating bulletType with color " + color);
    }
}
