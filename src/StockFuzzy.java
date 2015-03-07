import java.util.ArrayList;
import java.util.List;

public class StockFuzzy {
	public double RangeMin = 0;
	public double RangeMax = 1;
	public List<StockInput> Stocks;

	
	public List<String> GetFuzzyValue(double value)
	{
		List<String> result = new ArrayList<String>();
		
		for (StockInput input : Stocks) {
			if (input.IsInRange(value))
				result.add(input.Name);
		}
		
		return result;
	}
}
