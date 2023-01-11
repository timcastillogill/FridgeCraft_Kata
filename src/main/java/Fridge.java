public class Fridge implements FridgeService {
	private final Date date;
	private FridgeRepository fridgeRepository;


	public Fridge(Date date, FridgeRepository fridgeRepository) {
		this.date = date;
		this.fridgeRepository = fridgeRepository;
	}

	@Override
	public void open() {
		fridgeRepository.degradeFridgeItems();
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
