package club.allaboutjava.karthik.JunitAdvanced;

/**
 * Hello world!
 *
 */
public class CalculationController 
{
	
	CalculationService service;
	
	public CalculationController(CalculationService service){
		this.service= service;
	}
	
    public void computeNumbers(int a, int b,String operand){
    	switch (operand) {
		case "+":
			System.out.println(service.add(a, b));
			break;
		case "-":
			System.out.println(service.subtract(a, b));
			break;
		default:
			System.out.println("We do not support this operation at the moment");
			break;
		}
    }
}
