public class FridgeItemCondition {
	private String conditionName;
	private int rateOfDegradation;

	public FridgeItemCondition(String conditionName, int rateOfDegradation) {
		this.conditionName = conditionName;
		this.rateOfDegradation = rateOfDegradation;
	}

	public String getConditionName() {
		return conditionName;
	}

	public int getRateOfDegradation() {
		return rateOfDegradation;
	}
}
