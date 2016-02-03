package club.allaboutjava.karthik.JunitAdvanced;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * 	Junit test case by using Mockito.
 * </p>
 * 
 * @author karthik (karthikarun@outlook.com)
 *
 */
public class CalculationTesterWithMockito {
	CalculationService mockService = null;

	@Before
	public void init() {
		mockService = mock(CalculationService.class);
	}

	@Test
	public void test() {
		when(mockService.add(1, 2)).thenReturn(3);
		when(mockService.subtract(2, 1)).thenReturn(1);
		CalculationController controller = new CalculationController(mockService);
		controller.computeNumbers(1, 2, "+");
		verify(mockService, times(1)).add(1, 2);
		controller.computeNumbers(2, 1, "-");
		verify(mockService, times(1)).subtract(2, 1);
		controller.computeNumbers(2, 1, "*");
	}

}
