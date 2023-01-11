import java.util.ArrayList;

public class FridgeRepository {

	ArrayList<FridgeItem> currentFridgeStock;

	public FridgeRepository() {
		this.currentFridgeStock = new ArrayList<>();
	}

	public void degradeFridgeItems() {
		for (FridgeItem fridgeItem : this.currentFridgeStock) {
			fridgeItem.degradeItem();
		}
	}

	public ArrayList<FridgeItem> getCurrentFridgeStock() {
		return currentFridgeStock;
	}
}
