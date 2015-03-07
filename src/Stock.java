import java.lang.Math;
import java.util.Random;

public class Stock {
	
	private Random random = new Random();
	
	public double GetStockPrice(int day)
	{
		double result = 0;
		
		result = 10 
				+ (2.5 * Math.sin((2 * Math.PI * day)/19))
				+ (.8 * Math.cos((2 * Math.PI * day/5)))
				+ StockRandomness(day);
		
		return result;
	}
	

	public double StockRandomness(int day)
	{
		double result = 0;
		double randomSign = random.nextDouble() > .5 ? 1 : -1;
		
		random.setSeed(day);
		double absoluteRandomNumber= random.nextDouble();
		
		Logger.Log(absoluteRandomNumber);
		
		double randomNumber = absoluteRandomNumber * randomSign;
		
		result = 8 * randomNumber * (day % 2);
		
		return result;
	}
}
