public class FridgeItemCondition {
	private String name;
	private int rateOfDegradation;

	public FridgeItemCondition(String name, int rateOfDegradation) {
		this.name = name;
		this.rateOfDegradation = rateOfDegradation;
	}

	public String getName() {
		return name;
	}

	public int getRateOfDegradation() {
		return rateOfDegradation;
	}
}
