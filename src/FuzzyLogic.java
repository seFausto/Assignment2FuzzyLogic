
public class FuzzyLogic {

	public static void main(String[] args) {
		
		Logger.TurnLogginOn = true;
		
		Stock s = new Stock();
		System.out.println( s.GetStockPrice(1));
		System.out.println( s.GetStockPrice(2));
		System.out.println( s.GetStockPrice(3));
		System.out.println( s.GetStockPrice(4));
		System.out.println( s.GetStockPrice(5));
		
	}

}
