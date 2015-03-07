
public class Logger {

	public static Boolean TurnLogginOn = false;

	public static void Log(String message)
	{
		if (TurnLogginOn)
			System.out.println(message);
	}
	
	public static void Log(double value)
	{
		if (TurnLogginOn)
		{
			String message = Double.toString(value);
			System.out.println(message);
		}

	}
	
	
}
