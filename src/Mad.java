import java.lang.Math;
import java.util.Random;

public class Mad {
	private Random random = new Random();

	public double GetMad(int day) {
		double result = 0;
		double madRandom = 0;

		result = .5 * Math.cos(.3 * (double) day) - Math.sin(.3 * (double) day)
				+ madRandom;

		return result;
	}

	public double MadRandomness(int day) {
		double result = 0;
		double randomSign = random.nextDouble() > .5 ? 1 : -1;

		random.setSeed(day);
		double absoluteRandomNumber = random.nextDouble();
		double randomNumber = absoluteRandomNumber * randomSign;
		result = (.2 * randomNumber) * (double) (day % 3);

		return result;
	}
}
