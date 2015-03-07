public class StockInput {

	public String Name;
	public double RangeMin;
	public double RangeMax;

	public StockInput(String name, double rangeMin, double rangeMax) {
		Name = name;
		RangeMin = rangeMin;
		RangeMax = rangeMax;
	}

	public Boolean IsInRange(double value) {
		return (value >= RangeMin && value <= RangeMax);
	}
}
