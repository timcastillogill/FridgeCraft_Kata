
public class FridgeItem {
	private final String name;
	private Date expiryDate;
	private final String condition;
	private int expiryTimeCollated = 0;
	private final FridgeItemCondition fridgeItemCondition;

	public FridgeItem(String name, Date expiryDate, String condition, FridgeItemCondition fridgeItemCondition) {
		this.name = name;
		this.expiryDate = expiryDate;
		this.condition = condition;
		this.fridgeItemCondition = fridgeItemCondition;
	}

	public void degradeItem() {

		if (this.condition.equals(this.fridgeItemCondition.getName())) {
			expiryTimeCollated += this.fridgeItemCondition.getRateOfDegradation();
		}
		if (expiryTimeCollated >= 24) {
			expiryTimeCollated = expiryTimeCollated - 24;
			expiryDate.backOneDay();
		}
	}



	public String getName() {
		return name;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public String getCondition() {
		return condition;
	}

	public int getExpiryTimeCollated() {
		return expiryTimeCollated;
	}
}
