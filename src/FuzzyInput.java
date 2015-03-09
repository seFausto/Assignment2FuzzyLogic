public class FuzzyInput {

	public String Name;
	public double RangeMin;
	public double RangeMax;
	public double RangeMid;
	
	public FuzzyInput(String name, double rangeMin, double rangeMax) {
		Name = name;
		RangeMin = rangeMin;
		RangeMax = rangeMax;
		RangeMid = (rangeMax + rangeMin) / 2;
	}

	public Boolean IsInRange(double value) {
		return (value >= RangeMin && value <= RangeMax);
	}
}
