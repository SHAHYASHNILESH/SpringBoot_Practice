package design_patterns.behavioural.oberver.stock_monitoring;

public class InvestorA implements Observer {

	@Override
	public void update(String stockSymbol, double newPrice) {
		System.out.println("Investor A notified: Stock " + stockSymbol + " has a new price: $" + newPrice);
	}
}