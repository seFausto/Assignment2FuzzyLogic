public class FuzzyRule {

	public String GetOutput(FuzzyInput input1, FuzzyInput input2) {
		String result = "";

		if (input1.Name == "VeryLow") {
			result = VeryLowLogic(input2);
		} else if (input1.Name == "Low") {
			result = LowLogic(input2);
		} else if (input1.Name == "Medium") {
			result = MediumLogic(input2);
		} else if (input1.Name == "High") {
			result = HighLogic(input2);
		} else if (input1.Name == "VeryHigh") {
			result = VeryHighLogic(input2);
		}

		return result;
	}

	private String VeryHighLogic(FuzzyInput input2) {
		String result = "";

		if (input2.Name == "Positive") {
			result = "DoNotTrade";
		} else if (input2.Name == "Zero") {
			result = "SellMany";
		} else {
			result = "SellMany";
		}

		return result;
	}

	private String HighLogic(FuzzyInput input2) {
		String result = "";
		if (input2.Name == "Positive") {
			result = "BuyFew";
		} else if (input2.Name == "Zero") {
			result = "SellFew";
		} else {
			result = "SellMany";
		}
		return result;
	}

	private String MediumLogic(FuzzyInput input2) {
		String result = "";
		if (input2.Name == "Positive") {
			result = "BuyFew";
		} else if (input2.Name == "Zero") {
			result = "DoNoTrade";
		} else {
			result = "SellFew";
		}
		return result;
	}

	private String LowLogic(FuzzyInput input2) {
		String result = "";
		if (input2.Name == "Positive") {
			result = "BuyMany";
		} else if (input2.Name == "Zero") {
			result = "BuyFew";
		} else {
			result = "SellFew";
		}
		return result;
	}

	private String VeryLowLogic(FuzzyInput input2) {
		String result = "";
		if (input2.Name == "Positive") {
			result = "BuyMany";
		} else if (input2.Name == "Zero") {
			result = "BuyMany";
		} else {
			result = "DoNotTrade";
		}
		return result;
	}
}
