package week3;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorial(new Integer(69)));

	}
    
	static public BigDecimal bigDecFac(BigDecimal num){
		BigDecimal result = new BigDecimal(1);
		BigDecimal compare = new BigDecimal(1);
		for (int i = 0; num.compareTo(compare) > 0; i++) {
			result = result.multiply(num);
			num = num.subtract(compare);
		}
		return result;
	}
	
	static public double commonDouble(double num){
		double result = 1;
		while(num > 1){
			result*=num;
			num-=1;
		}
		return result;
	}
	
	static public BigInteger bigIntFack(BigInteger value){
		BigInteger result = BigInteger.ONE;
		System.out.println(value.compareTo(BigInteger.ONE));
	    while (value.compareTo(BigInteger.ONE) > 0) {
	        result = result.multiply(value);
	        value = value.subtract(BigInteger.ONE);
	    }

	    return result;
	}
	
	static public long commomLongFac(long num){
		int result = 1;
		for (int i = 0; i <= num; i++) {
			result*=i;
		}
		return result;
	}
	
	static <T extends Number> Number factorial(T num) {
		if ((num instanceof Double) || (num instanceof Float) || (num instanceof BigDecimal)) {
			if (num.doubleValue() > 20) {
				if (num instanceof BigDecimal) {
					return bigDecFac((BigDecimal) num);
				}
				else if (num instanceof Double){
					return bigDecFac(new BigDecimal((Double)num));			
			    }
				else{
					return bigDecFac(new BigDecimal((Float)num));		
				}
			}
			else{
				double result = commonDouble(num.doubleValue());
				return new BigDecimal(result);
			}
		}
		else{
			if(num.longValue() > 20){
				if(num instanceof BigInteger ){
					return bigIntFack((BigInteger)num);
				}
				else {
					return bigIntFack(BigInteger.valueOf(num.longValue()));
				}			
			}
			else{
				long result = commomLongFac(num.longValue());
				if(num instanceof BigInteger){
					return BigInteger.valueOf(commomLongFac(result));
				}
				else if(num instanceof Byte && result <= Byte.MAX_VALUE){
					return Byte.valueOf((byte)result);
				}
				else if(num instanceof Short && result <= Short.MAX_VALUE){
					return Short.valueOf((short)result);
				}
				else if(num instanceof Integer && result <= Integer.MAX_VALUE){
					return Integer.valueOf((int)result);
				}
				else {
					return Long.valueOf(commomLongFac(num.longValue()));
				}
			}
			
		}

	}
}
