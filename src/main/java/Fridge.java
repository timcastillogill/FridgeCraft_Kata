import java.util.ArrayList;

public class Fridge implements FridgeService {
	private final Clock clock;
	private FridgeRepository fridgeRepository;


	public Fridge(Clock clock, FridgeRepository fridgeRepository) {
		this.clock = clock;
		this.fridgeRepository = fridgeRepository;
	}

	@Override
	public void open() {
		fridgeRepository.degrade();
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
