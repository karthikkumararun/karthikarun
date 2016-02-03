package club.allaboutjava.karthik.JunitAdvanced;

public class CalculationService {

	public int add(int a,int b){
		return a+b;
	}
	public int subtract(int a,int b){
		return a-b;
	}
	
	public int calculate(int a,int b,String operand){
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
}
