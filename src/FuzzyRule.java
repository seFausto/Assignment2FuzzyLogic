public class FuzzyRule {

	static public String GetOutput(String input1, String input2) {
		String result = "";

		if (input1 == "VeryLow") {
			result = VeryLowLogic(input2);
		} else if (input1 == "Low") {
			result = LowLogic(input2);
		} else if (input1 == "Medium") {
			result = MediumLogic(input2);
		} else if (input1 == "High") {
			result = HighLogic(input2);
		} else if (input1 == "VeryHigh") {
			result = VeryHighLogic(input2);
		}

		return result;
	}

	static private String VeryHighLogic(String input2) {
		String result = "";

		if (input2 == "Positive") {
			result = "DoNotTrade";
		} else if (input2 == "Zero") {
			result = "DoNotTrade";
		} else {
			result = "SellMany";
		}

		return result;
	}

	static private String HighLogic(String input2) {
		String result = "";
		if (input2 == "Positive") {
			result = "BuyFew";
		} else if (input2 == "Zero") {
			result = "SellFew";
		} else {
			result = "SellMany";
		}
		return result;
	}

	static private String MediumLogic(String input2) {
		String result = "";
		if (input2 == "Positive") {
			result = "BuyFew";
		} else if (input2 == "Zero") {
			result = "DoNoTrade";
		} else {
			result = "SellFew";
		}
		return result;
	}

	static private String LowLogic(String input2) {
		String result = "";
		if (input2 == "Positive") {
			result = "BuyMany";
		} else if (input2 == "Zero") {
			result = "BuyFew";
		} else {
			result = "SellFew";
		}
		return result;
	}

	static private String VeryLowLogic(String input2) {
		String result = "";
		if (input2 == "Positive") {
			result = "BuyMany";
		} else if (input2 == "Zero") {
			result = "BuyFew";
		} else {
			result = "DoNotTrade";
		}
		return result;
	}
}
