import java.util.ArrayList;

public class Fridge implements FridgeService {
	private final Clock clock;

	ArrayList<fridgeItem> fridgeItems;
	public Fridge(Clock clock) {
		this.clock = clock;
		this.fridgeItems = new ArrayList<fridgeItem>();
	}

	@Override
	public void open() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(String item, String expiryDate, String condition) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void close() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove(String item) {
		throw new UnsupportedOperationException();
	}
}
