import java.util.ArrayList;
import java.util.List;

public class FuzzyLogic {

	public static void main(String[] args) {

		Logger.TurnLogginOn = true;

		StockGenerator stockGenerator = new StockGenerator();
		MadGenerator madGenerator = new MadGenerator();

		Fuzzy sf = SetStocksFuzzy();

		Fuzzy madFuzzy = SetMadFuzzy();

		Broker broker = new Broker(1200);
		double lastStockPrice = 0;
		
		for (int day = 1; day <= 150; day++) {

			double stockPrice = stockGenerator.GetStockPrice(day);
			double mad = madGenerator.GetMad(day);

			List<String> values = sf.GetFuzzyValue(stockPrice);
			List<String> madValues = madFuzzy.GetFuzzyValue(mad);

			if (values.size() == 0 || madValues.size() == 0) {
				System.err.println("No fuzzy outputs were returned. "
						+ "This is a critical error and should not happen");
			}

			String actionOutput = FuzzyRule.GetOutput(values.get(0),
					madValues.get(0));

			System.out.println("Day: " + day);

			System.out.println("Money Before Close: " + broker.Money
					+ "| Stocks Before Close: " + broker.NumberOfStocks
					+ "| Value: " + stockPrice + " and Mad: " + mad
					+ ". Broker should: " + actionOutput);

			broker.TakeAction(actionOutput, stockPrice);
			System.out.println("Money: " + broker.Money + "| Stocks: "
					+ broker.NumberOfStocks);

			System.out.println();

			lastStockPrice = stockPrice;
		}

		// Show Money equivalent
		System.out.println("TOTAL MONEY: "
				+ (broker.Money + (broker.NumberOfStocks * lastStockPrice)));

	}

	private static Fuzzy SetMadFuzzy() {
		Fuzzy madFuzzy = new Fuzzy();
		madFuzzy.RangeMax = 1;
		madFuzzy.RangeMin = -1;
		madFuzzy.Inputs = new ArrayList<FuzzyInput>();
		madFuzzy.Inputs.add(new FuzzyInput("Negative",
				Double.NEGATIVE_INFINITY, -1));
		madFuzzy.Inputs.add(new FuzzyInput("Zero", 0, 0));
		madFuzzy.Inputs.add(new FuzzyInput("Positive", 1,
				Double.POSITIVE_INFINITY));
		return madFuzzy;
	}

	private static Fuzzy SetStocksFuzzy() {
		Fuzzy sf = new Fuzzy();
		sf.RangeMax = 20;
		sf.RangeMin = 0;

		//
		sf.Inputs = new ArrayList<FuzzyInput>();

		sf.Inputs.add(new FuzzyInput("VeryLow", 0, 4));
		sf.Inputs.add(new FuzzyInput("Low", 4, 10));
		sf.Inputs.add(new FuzzyInput("Medium", 9, 14));
		sf.Inputs.add(new FuzzyInput("High", 13, 17));
		sf.Inputs.add(new FuzzyInput("VeryHigh", 16, Double.MAX_VALUE));
		return sf;
	}
}