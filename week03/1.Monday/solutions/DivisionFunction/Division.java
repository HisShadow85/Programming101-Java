package week3;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Division {
    
	static <T1 extends Number , T2 extends Number>  Number division(T1 num1, T2 num2){
		if(num1 instanceof BigDecimal || num2 instanceof BigDecimal || num1 instanceof BigInteger || num2 instanceof BigInteger){
			BigDecimal num11;
			if(num1 instanceof BigDecimal){
				num11 = (BigDecimal) num1;
			}else if(num1 instanceof BigInteger ){
				num11 = new BigDecimal((BigInteger)num1);
			}else{
				num11 = new BigDecimal(num1.doubleValue());
			}
			BigDecimal num22;
			if(num2 instanceof BigDecimal){
				num22 = (BigDecimal) num2;
			}else if(num2 instanceof BigInteger ){
				num22 = new BigDecimal((BigInteger)num2);
			}else{
				num22 = new BigDecimal(num2.doubleValue());
			}
			return  num11.divide(num22);
		}
		else
		 return num1.doubleValue() / num2.doubleValue();
	}
	public static void main(String[] args) {
		System.out.println(division(5,6.7));
	}

}
