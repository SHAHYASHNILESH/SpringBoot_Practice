package design_patterns.behavioural.oberver.stock_monitoring;

public interface Subject {
	void registerObserver(Observer o);

	void removeObserver(Observer o);

	void notifyObservers(String stockSymbol, double newPrice);
}