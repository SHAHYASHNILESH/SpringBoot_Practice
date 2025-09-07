package design_patterns.structural.decorator.coffee_shop;

public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        // TODO: Complete this method to return the description of the decorated coffee.
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        // TODO: Complete this method to return the cost of the decorated coffee.
        return coffee.getCost();
    }
}