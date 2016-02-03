package club.allaboutjava.karthik.JunitAdvanced;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;

/**
 * <p>
 * Junit test case by using mockito annotations.
 * </p>
 * 
 * @author karthik (karthikarun@outlook.com)
 *
 */
public class CalculationTesterWithMockitoAnnotations {

	@Mock
	CalculationService mockService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
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

	@Test
	public void testMultipleCalls() {
		when(mockService.calculate(anyInt(), anyInt(),anyString())).then(new Answer<Integer>() {
			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				Integer a =(Integer)arguments[0];
				Integer b =(Integer)arguments[1];
				String operand =(String)arguments[2];
				if("+".equals(operand)){
					return a+b;
				}
				else if("-".equals(operand)){
					return a-b;
				}
				else if("*".equals(operand)){
					return a*b;
				}
				else if("/".equals(operand)){
					return a/b;
				}
				else{
					return 0;
				}
			}
		});
		NewCalculationController controller = new NewCalculationController(mockService);
		controller.computeNumbers(1, 2, "+");
		controller.computeNumbers(1, 2, "1");
		controller.computeNumbers(1, 2, "*");
		controller.computeNumbers(2, 1, "/");
		controller.computeNumbers(2, 1, "%");
	}
}
