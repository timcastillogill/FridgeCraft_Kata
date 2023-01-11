import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class FridgeShould {

	@Mock
	Clock clock;
	@Mock
	FridgeRepository fridgeRepository;
	private Fridge fridge;

	@BeforeEach
	void setup() {
		fridge = new Fridge(clock, fridgeRepository);
	}

	@Test
	public void if_opened_degrade_items_inside_fridge_by_one_hour_if_sealed() {
		fridge.open();
		verify(fridgeRepository).degrade();
	}

}