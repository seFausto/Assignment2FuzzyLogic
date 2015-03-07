import java.util.ArrayList;
import java.util.List;

public class FuzzyLogic {

	public static void main(String[] args) {

		Logger.TurnLogginOn = true;

		StockGenerator s = new StockGenerator();
		MadGenerator m = new MadGenerator();

		StockFuzzy sf = new StockFuzzy();
		sf.RangeMax = 20;
		sf.RangeMin = 0;

		sf.Stocks = new ArrayList<StockInput>();

		sf.Stocks.add(new StockInput("VeryLow", 0, 4));
		sf.Stocks.add(new StockInput("Low", 4, 10));
		sf.Stocks.add(new StockInput("Medium", 9, 14));
		sf.Stocks.add(new StockInput("High", 13, 17));
		sf.Stocks.add(new StockInput("VeryHigh", 16, Double.MAX_VALUE));

		for (int day = 1; day <= 100; day++) {

			double value = s.GetStockPrice(day);
			List<String> values = sf.GetFuzzyValue(value);

			System.out.println("Value: " + value + " for day: " + day);
			for (String string : values) {

				System.out.println(string);
			}
		}

	}
}
