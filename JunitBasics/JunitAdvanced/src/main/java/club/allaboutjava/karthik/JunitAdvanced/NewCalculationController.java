package club.allaboutjava.karthik.JunitAdvanced;

public class NewCalculationController {

	CalculationService service;

	public NewCalculationController(CalculationService service) {
		this.service = service;
	}

	public void computeNumbers(int a, int b, String operand) {
		service.calculate(a, b, operand);
	}
}
