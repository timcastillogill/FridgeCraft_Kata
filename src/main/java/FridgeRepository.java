import java.util.ArrayList;

public class FridgeRepository {

	ArrayList<FridgeItem> currentFridgeStock;

	public FridgeRepository() {
		this.currentFridgeStock = new ArrayList<>();
	}

	public void degradeFridgeItems() {
		for (int i = 0; i < this.currentFridgeStock.size(); i++) {
			this.currentFridgeStock.get(i).degradeItem();
		}
	}

	public ArrayList<FridgeItem> getCurrentFridgeStock() {
		return currentFridgeStock;
	}
}
