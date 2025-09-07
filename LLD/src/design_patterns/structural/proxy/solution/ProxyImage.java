package design_patterns.structural.proxy.solution;

public class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;//Proxy reference to real Image

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); //Image is loaded + cached
        }
        realImage.display();
    }
}
