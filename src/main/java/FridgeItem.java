
public class FridgeItem {
	private final String name;
	private Date expiryDate;
	private final FridgeItemCondition fridgeItemCondition;
	private int expiryTimeCollated = 0;

	public FridgeItem(String name, Date expiryDate, FridgeItemCondition fridgeItemCondition) {
		this.name = name;
		this.expiryDate = expiryDate;
		this.fridgeItemCondition = fridgeItemCondition;
	}

	public void degradeItem() {
		expiryTimeCollated += this.fridgeItemCondition.getRateOfDegradation();
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

	public int getExpiryTimeCollated() {
		return expiryTimeCollated;
	}
}
