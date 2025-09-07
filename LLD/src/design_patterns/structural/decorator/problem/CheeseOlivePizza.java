package design_patterns.structural.decorator.problem;

public class CheeseOlivePizza extends CheesePizza {

    @Override
    public String getDescription() {
        return super.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.50;
    }
}