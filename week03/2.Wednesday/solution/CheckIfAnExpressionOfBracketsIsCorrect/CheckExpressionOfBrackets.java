package week3;

public class CheckExpressionOfBrackets {

	public static void main(String[] args) {
		System.out.println(check("()(())(()(()))"));
		System.out.println(check("()(()))(()(()))"));

	}
    
	static boolean check(String expression){
		int counter = 0;
		for (int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i) == '('){
				counter++;
			}else if(expression.charAt(i)==')'){
				counter--;
			}
			
			if(counter < 0){
				return false;
			}
		}
		
		if(counter != 0){
			return false;
		}
		
		return true;
	}
}
