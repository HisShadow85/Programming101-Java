package week3;

public class Multiplication {
	static <T1 extends Number , T2 extends Number>  double multiplication(T1 num1, T2 num2){
		 return num1.doubleValue() * num2.doubleValue();
	}
	public static void main(String[] args) {
		System.out.println(multiplication(5,6.7));


	}

}
