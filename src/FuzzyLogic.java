import java.util.ArrayList;
import java.util.List;

public class FuzzyLogic {

	private static final String header = "Day, Money, Stocks, Stock Value, Fuzzy Stock, MAD Value, Fuzzy MAD, Fuzzy Output ";

	public static void main(String[] args) {
		
		String fileOutput = "";
		String fileName = null;
		Logger.TurnLogginOn = true;

		if (args.length > 0)
		{
			fileName = args[0];
		}
		
		
		StockGenerator stockGenerator = new StockGenerator();
		MadGenerator madGenerator = new MadGenerator();

		Fuzzy sf = SetStocksFuzzy();

		Fuzzy madFuzzy = SetMadFuzzy();

		Broker broker = new Broker(1200);
		double lastStockPrice = 0;
		
		System.out.println(header);
		fileOutput += header + "\n";
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

			String print = day +"," + broker.Money
					+ ","+ broker.NumberOfStocks
					+ "," + stockPrice + ","+ values.get(0)
					+"," + mad + "," + madValues.get(0)
					+ "," + actionOutput;
			System.out.println(print);
			
			fileOutput += print + "\n";

			broker.TakeAction(actionOutput, stockPrice);
		
					lastStockPrice = stockPrice;
		}

		// Show Money equivalent
		String footer = "TOTAL MONEY: "
				+ (broker.Money + (broker.NumberOfStocks * lastStockPrice));
		System.out.println(footer);
		
		fileOutput += footer;

		
		if (fileName != null)
		{
			File.WriteFile(fileName, fileOutput);
		}
		

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