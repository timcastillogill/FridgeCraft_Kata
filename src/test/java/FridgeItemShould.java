import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FridgeItemShould {

	@Mock
	FridgeItemCondition fridgeItemCondition;
	@Mock
	Date date;
	private FridgeItem sealedItem;
	private FridgeItem openedItem;

	@Test
	public void degrade_a_sealed_item_by_one_hour() {
		sealedItem = new FridgeItem("Yogurt", date, fridgeItemCondition);
		given(fridgeItemCondition.getRateOfDegradation()).willReturn(1);

		sealedItem.degradeItem();

		assertThat(sealedItem.getExpiryTimeCollated()).isEqualTo(1);
	}

	@Test
	public void degrade_an_open_item_by_five_hours() {
		openedItem = new FridgeItem("Yogurt", date, fridgeItemCondition);
		given(fridgeItemCondition.getRateOfDegradation()).willReturn(5);

		openedItem.degradeItem();

		assertThat(openedItem.getExpiryTimeCollated()).isEqualTo(5);
	}

	@Test
	public void adjusts_the_expiry_date_if_expiry_time_collated_reaches_twenty_four() {
		openedItem = new FridgeItem("Yogurt", date, fridgeItemCondition);
		given(fridgeItemCondition.getRateOfDegradation()).willReturn(24);

		openedItem.degradeItem();

		verify(date).backOneDay();
		assertThat(openedItem.getExpiryTimeCollated()).isEqualTo(0);
	}


}