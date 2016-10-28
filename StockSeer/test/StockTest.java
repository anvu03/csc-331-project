
import java.io.IOException;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class StockTest {

	public static void main(String[] args) {
		Stock stock = null;
		try {
			stock = YahooFinance.get("SSNLF");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//
		// BigDecimal price = stock.getQuote().getPrice();
		// BigDecimal change = stock.getQuote().getChangeInPercent();
		// BigDecimal peg = stock.getStats().getPeg();
		// BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
		stock.print();
	}

}
