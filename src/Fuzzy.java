import java.util.ArrayList;
import java.util.List;

public class Fuzzy {
	public double RangeMin = 0;
	public double RangeMax = 1;
	public List<FuzzyInput> Inputs;

	public List<String> GetFuzzyValue(double value) {
		List<String> result = new ArrayList<String>();

		double highestSubcriptionRate = -1;
		
		for (FuzzyInput input : Inputs) {
			if (input.IsInRange(value) ) {
				result.add(input.Name);
			}
		}

		// get the one that has higher subscription rate,
		// by getting the one closest to the middle of the range

		return result;
	}
}
