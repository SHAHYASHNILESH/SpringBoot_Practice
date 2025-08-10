package design_patterns.behavioural.oberver.stock_monitoring;

public class InvestorB implements Observer {

	@Override
	public void update(String stockSymbol, double newPrice) {
		System.out.println("Investor B notified: Stock " + stockSymbol + " has a new price: $" + newPrice);
	}
}