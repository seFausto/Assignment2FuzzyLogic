import java.util.ArrayList;
import java.util.List;

public class FuzzyLogic {

	public static void main(String[] args) {

		Logger.TurnLogginOn = true;

		StockGenerator s = new StockGenerator();
		MadGenerator m = new MadGenerator();

		Fuzzy sf = new Fuzzy();
		sf.RangeMax = 20;
		sf.RangeMin = 0;

		sf.Inputs = new ArrayList<FuzzyInput>();

		sf.Inputs.add(new FuzzyInput("VeryLow", 0, 4));
		sf.Inputs.add(new FuzzyInput("Low", 4, 10));
		sf.Inputs.add(new FuzzyInput("Medium", 9, 14));
		sf.Inputs.add(new FuzzyInput("High", 13, 17));
		sf.Inputs.add(new FuzzyInput("VeryHigh", 16, Double.MAX_VALUE));

		
		Fuzzy madFuzzy = new Fuzzy();
		madFuzzy.RangeMax = 1;
		madFuzzy.RangeMin = -1;
		madFuzzy.Inputs = new ArrayList<FuzzyInput>();
		madFuzzy.Inputs.add( new FuzzyInput("Negative", Double.NEGATIVE_INFINITY, -1));
		madFuzzy.Inputs.add( new FuzzyInput("Zero", 0, 0));
		madFuzzy.Inputs.add( new FuzzyInput("Positive", 1, Double.POSITIVE_INFINITY));
		
		for (int day = 1; day <= 100; day++) {

			double value = s.GetStockPrice(day);
			double mad = m.GetMad(day);
			
			
			List<String> values = sf.GetFuzzyValue(value);
			List<String> madValues = madFuzzy.GetFuzzyValue(mad);
			
			
			System.out.println("Value: " + value + " and Mad: "+ mad +" for day: " + day);
//			for (String string : values) {
//				System.out.print(string);
//			}
//			
//			System.out.print(" - ");
//			
//			for (String string : madValues) {
//				System.out.print(string);
//			}
			
			System.out.println();
		}

	}
}
