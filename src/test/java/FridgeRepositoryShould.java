import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FridgeRepositoryShould {

	@Mock Date date;
	@Mock FridgeItemCondition fridgeItemCondition;
	private FridgeRepository fridgeRepository;
	private ArrayList<FridgeItem> testFridgeItems;
	private FridgeItem fridgeItem;

	@BeforeEach
	void setup() {
		fridgeRepository = new FridgeRepository();
		fridgeItem = new FridgeItem("Cheese", date, fridgeItemCondition);
	}

	@Test
	public void degrade_an_item() {
		fridgeRepository.degradeFridgeItems();
		testFridgeItems = fridgeRepository.getCurrentFridgeStock();
		given(fridgeItemCondition.getRateOfDegradation()).willReturn(1);

		testFridgeItems.add(fridgeItem);
		fridgeRepository.degradeFridgeItems();

		assertThat(fridgeItem.getExpiryTimeCollated()).isEqualTo(1);
	}


}