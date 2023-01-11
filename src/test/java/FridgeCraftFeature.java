import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class FridgeCraftFeature {

	@Mock Clock clock;

	private Fridge fridge;
	private FridgeRepository fridgeRepository;

	@BeforeEach
	void setup() {
		fridgeRepository = new FridgeRepository();
	    fridge = new Fridge(clock, fridgeRepository);
	}

	@Test
	public void fridge_accepts_items_and_calculates_expiration_date() {

		given(clock.dateNow()).willReturn("18/10/2021");

		fridge.open();
		fridge.add("Milk", "21/10/2021", "sealed");
		fridge.add("Cheese", "18/11/2021", "sealed");
		fridge.add("Beef", "20/10/2021", "sealed");
		fridge.add("Lettuce", "22/10/2021", "sealed");
		fridge.close();

		given(clock.dateNow()).willReturn("19/10/2021");

		fridge.open();
		fridge.close();

		fridge.open();
		fridge.close();

		fridge.open();
		fridge.remove("Milk");
		fridge.close();

		fridge.open();
		fridge.add("Milk", "26/10/21", "opened");
		fridge.add("Peppers", "26/10/2021", "opened");
		fridge.close();

	}
}
