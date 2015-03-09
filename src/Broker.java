public class Broker {

	public double Money;
	public int NumberOfStocks = 0;

	private final double dailyTradeMax = 800;

	// private double dailyTrade = 0;

	public Broker(double startingMoney) {
		Money = startingMoney;
	}

	public void TakeAction(String value, double stockPrice) {

		double tradeValues = GetTradeValues(value);

		if (tradeValues > 0) {
			// check if we have enough money to buy that amount of stocks and
			// adjust
			BuyStocks(Math.abs(tradeValues), stockPrice);
		} else if (tradeValues < 0) {
			// check if we have enough stocks to sell, and adjust
			SellStocks(Math.abs(tradeValues), stockPrice);
		} else {
			// do nothing
		}
	}

	private void SellStocks(double tradeValues, double stockPrice) {

		// do nothing if no stocks
		if (NumberOfStocks == 0)
			return;

		if (NumberOfStocks >= tradeValues) {
			// sell
			NumberOfStocks -= tradeValues;
			Money += (tradeValues * stockPrice);

		} else {
			tradeValues = NumberOfStocks;
			NumberOfStocks = 0;
			Money += (tradeValues * stockPrice);
		}

	}

	private void BuyStocks(double tradeValues, double stockPrice) {
		// do nothing if no money
		if (Money < stockPrice)
			return;

		double moneyNeededToBuyStocks = tradeValues * stockPrice;

		if (Money >= moneyNeededToBuyStocks) {
			NumberOfStocks += tradeValues;
			Money -= moneyNeededToBuyStocks;

		} else {
			// get how many stocks we can buy with the money we have
			double stocksWeCanBuy = Math.floor(Money / stockPrice);
			Money = Money / stockPrice;
			NumberOfStocks += (int) (stocksWeCanBuy * stockPrice);
		}

	}

	public double GetTradeValues(String value) {
		double result = 0;

		switch (value) {
		case "SellMany":
			result = -100;
			break;
		case "SellFew":
			result = -10;
			break;
		case "DoNotTrade":
			result = 0;
			break;
		case "BuyFew":
			result = 10;
			break;
		case "BuyMany":
			result = 100;
			break;
		default:
			result = 0;
		}

		return result;
	}
}
