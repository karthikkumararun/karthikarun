package club.allaboutjava.karthik.JunitAdvanced;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * 	Junit test case by using mock objects
 * </p>
 * 
 * @author karthik (karthikarun@outlook.com)
 *
 */
public class CalculationTester {

	private CalculationServiceMock mockService;

	class CalculationServiceMock extends CalculationService {

		@Override
		public int add(int a, int b) {
			return 3;
		}

		@Override
		public int subtract(int a, int b) {
			return 1;
		}

	}

	@Before
	public void init() {
		mockService = new CalculationServiceMock();
	}

	@Test
	public void test() {
		CalculationController controller = new CalculationController(mockService);
		controller.computeNumbers(1, 2, "+");
		controller.computeNumbers(2, 1, "-");
		controller.computeNumbers(2, 1, "*");
	}

}
