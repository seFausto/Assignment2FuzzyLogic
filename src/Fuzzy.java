import java.util.ArrayList;
import java.util.List;

public class Fuzzy {
	public double RangeMin = 0;
	public double RangeMax = 1;
	public List<FuzzyInput> Inputs;

	
	public List<String> GetFuzzyValue(double value)
	{
		List<String> result = new ArrayList<String>();
		
		double subscriptionValue = 0;
		
		for (FuzzyInput input : Inputs) {
			if (input.IsInRange(value))
			{	
				result.add(input.Name);
			}
		}
		
		return result;
	}
}
