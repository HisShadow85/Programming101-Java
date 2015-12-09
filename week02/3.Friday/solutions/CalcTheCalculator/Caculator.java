package week2;

import java.util.Stack;

public class Caculator{
	private final static byte[][] priority = { { 2, 3 }, { 2,3 }, { 4, 4 }, { 4, 4 }, { 12, 12 }, { 15, 0 }, { 1, 0 }, { 0, 0 },{5, 5} };
	private final static char[] operatorSignature = { '+', '-', '*', '/', '!', '(', ')', '#','^' };
	private final static Byte bottom = new Byte((byte) 7);
    //2+3!^2+((-6-7+9-5)*-1)+2^3^2
	//2^3^2+2+(-6-7+9-5)*-1+3!^2
	public static void main(String[] args) {
		//System.out.println(calculate("-5+6*6+(3/(3-1))*2^3"));
		System.out.println(calculate("2+3!^2+((-6-7+9-5)*-1)+2^3^2"));
		System.out.println(calculate("2^3^2+2+(-6-7+9-5)*-1+3!^2"));
	}

	static Stack<String> getRPN(String expression) {
		Stack<Byte> operStack = new Stack<Byte>();
		Stack<String> output = new Stack<String>();
		operStack.push(bottom);
		boolean operator = true;// announce that we don't expect next non digit character to be an operator
		boolean negative = false;

		StringBuilder sb = new StringBuilder(); // here we will store the next token which is to be putted into the output stack
		for (int currChar = 0; currChar < expression.length(); currChar++) {
			if (Character.isDigit(expression.charAt(currChar))) {// if the next character is a digit
				operator = false;// announce that we expect next non digit character to be an operator
				sb.setLength(0);// clear the buffer
				sb.append(expression.charAt(currChar));// put the current digit into the buffer
				// put the next sequence of digits into the buffer
				while (currChar + 1 < expression.length() && Character.isDigit(expression.charAt(currChar + 1))) {
					sb.append(expression.charAt(++currChar));
				}
				if(currChar + 1 < expression.length() && expression.charAt(currChar + 1)== '.'){
					sb.append(expression.charAt(++currChar));
					while (currChar + 1 < expression.length() && Character.isDigit(expression.charAt(currChar + 1))) {
						sb.append(expression.charAt(++currChar));
					}
				}

				if (negative) { // if the number appear to be negative
					sb.insert(0, '-');
					negative = false;
				}
				output.push(sb.toString());
			} else {// is non digit
				byte operatorIndex = 0;

				if (expression.charAt(currChar) == '-' && operator == true) {
					operator = false;// announce that we expect next non digit character to be an operator
					negative = negative ? false : true;// reverse the negative condition ( -- => +)
					continue;
				}
				// extract the operator code
				switch (expression.charAt(currChar)) {
				case '+': operatorIndex = 0;break;
				case '-': operatorIndex = 1;break;
				case '*': operatorIndex = 2;break;
				case '/': operatorIndex = 3;break;
				case '!': operatorIndex = 4;break;
				case '(': operatorIndex = 5;break;
				case ')': operatorIndex = 6;break;
				case '^': operatorIndex = 8;break;
				default:continue;
				}

				while (priority[operStack.peek()][1] > priority[operatorIndex][0]) {
					char operatorCar = operatorSignature[operStack.pop()];
					// every popped operator is pushed into the output
					output.push(Character.toString(operatorCar));
				}

				if (operatorIndex != 6) {
					operStack.push(operatorIndex);
				}else{
					operStack.pop();//remove enclosing parentheses
				}
				
				if(operatorIndex != 4){
					operator = true;
				}
			}
		}

		while (operStack.size() > 1) {
			output.push(Character.toString(operatorSignature[operStack.pop()]));
		}
		Stack<String> reverseOutput = new Stack<String>();
		while (!output.isEmpty()) {
			reverseOutput.push(output.pop());
		}
		return reverseOutput;
	}

	static double calculate(String expression) {
		Stack<String> expressionRPN = getRPN(expression);
		if (expressionRPN.isEmpty()) {
			return 0.0;
		}
		double prefix = 0.0;
		Stack<Double> numStack = new Stack<Double>();

		while (expressionRPN.size() > 0) {
			String token = expressionRPN.pop();
			switch (token) {
			case "+":prefix = numStack.pop();
				     numStack.push(numStack.pop() + prefix);
				     break;
			case "-":prefix = numStack.pop();
				     numStack.push(numStack.pop() - prefix);
				     break;
			case "*":prefix = numStack.pop();
				     numStack.push(numStack.pop() * prefix);
				     break;
			case "/":prefix = numStack.pop();
				     numStack.push(numStack.pop() / prefix);
				     break;
			case "!":numStack.push(factorial(numStack.pop()));
				     break;
			case "^":prefix = numStack.pop();
			         numStack.push(power(numStack.pop(), (long)prefix));
			         break;
			default: numStack.push(Double.parseDouble(token));
				     break;
			}
		}
		return numStack.pop();
	}

	static double factorial(double num) {
		assert num >= 0 : "factorial" + num;
		double fac = 1;
		for (; num > 1; num-=1.0) {
			fac *= num;
		}
		return fac;
	}
	
	static double power(double x, long y){
		if(y == 0){ return 1;}
		if(x == 0){return 0;}
		if(y == 1){return x;}
		if(y == -1){return 1/x;}
		long end = y < 0 ? -y : y;
		end = (y&1)==1? end-1:end;
		
		double result = x;
		for (int i = 1; i < end; i<<=1) {
			result*=result;
		}
		
		if((y&1) == 1){
			result*=x;
		}
		
		
		return  y > 0 ? result : 1/result; 
		
	}

}
