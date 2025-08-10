package design_patterns.behavioural.oberver.stock_monitoring;

public interface Observer {
	void update(String stockSymbol, double newPrice);
}