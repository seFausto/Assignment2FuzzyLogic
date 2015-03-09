import java.lang.Math;
import java.util.Random;

public class StockGenerator {

	private Random random = new Random();

	public double GetStockPrice(int day) {
		double result = 0;

		// Surround in this do, to prevent 0 value stocks
		do {
			result = 10 + (2.5 * Math.sin((2 * Math.PI * (double) day) / 19))
					+ (.8 * Math.cos((2 * Math.PI * (double) day / 5)))
					+ StockRandomness(day);
		} while (result < 0);

		return result;
	}

	public double StockRandomness(int day) {
		double result = 0;

		double randomSign = random.nextDouble() > .5 ? 1 : -1;

		double absoluteRandomNumber = random.nextDouble();

		double randomNumber = absoluteRandomNumber * randomSign;

		result = 8 * randomNumber * (double) (day % 2);

		return result;
	}
}
