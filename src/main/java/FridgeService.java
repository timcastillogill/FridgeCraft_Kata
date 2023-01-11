public interface FridgeService {
	void open();

	void close();

	void add(String item, String expiry, String condition);

	void remove(String item);
}
