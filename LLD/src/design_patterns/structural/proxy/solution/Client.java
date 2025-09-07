package design_patterns.structural.proxy.solution;

public class Client {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("dog.png");
        Image img2 = new ProxyImage("cat.png");
        //The image is loaded lazily when needed,
        // saving time and resources if the
        // image is never displayed.
        img1.display();
        img1.display();

    }
}