import java.util.ArrayList;

public class FridgeRepository {

	ArrayList<FridgeItem> currentFridgeStock;
	public void degrade() {
		throw new UnsupportedOperationException();
	}

	public ArrayList<FridgeItem> getCurrentFridgeStock() {
		return currentFridgeStock;
	}
}
