package design_patterns.structural.flyweight.problem;

class Bullet {
    private String color;  // Intrinsic property shared by all bullets
    private int x, y;      // Extrinsic properties unique to each bullet
    private int velocity;

    public Bullet(String color, int x, int y, int velocity) {
        this.color = color; // Same for all bullets
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        System.out.println("Creating bullet at (" + x + ", " + y + ") with velocity " + velocity);
    }

    public void display() {
        System.out.println("Bullet at (" + x + ", " + y + ") moving at velocity " + velocity);
    }
}
