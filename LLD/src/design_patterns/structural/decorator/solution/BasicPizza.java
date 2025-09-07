package design_patterns.structural.decorator.solution;

public class BasicPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Basic Pizza";

    }

    @Override
    public double getCost() {
        return 5.00; //base cost
    }
}
