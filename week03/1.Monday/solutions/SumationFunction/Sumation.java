package week3;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Sumation {
	
	static <V1 extends Number , V2 extends Number> Number sum( V1 num1, V2 num2 ){
		if(num1 instanceof BigDecimal || num2 instanceof BigDecimal){
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
			return  num11.add(num22);
		}else if(num1 instanceof BigInteger || num2 instanceof BigInteger){
			BigInteger num11;
			if(num1 instanceof BigInteger){
				num11 = (BigInteger) num1;
			}
			else{
				num11 = BigInteger.valueOf(num1.longValue());
			}
			BigInteger num22;
			if(num2 instanceof BigDecimal){
				num22 = (BigInteger) num2;
			}else{
				num22 = BigInteger.valueOf(num2.longValue());
			}
			return  num11.add(num22);
		}else if(num1 instanceof Double || num2 instanceof Double){	
			if(isDoubleOverflow(num1.doubleValue(),num2.doubleValue(),Double.MAX_VALUE,Double.MIN_VALUE)){
				return BigDecimal.valueOf(num1.doubleValue()).add(BigDecimal.valueOf(num2.doubleValue()));
			}else{
				return Double.valueOf(num1.doubleValue()+num2.doubleValue());
			}
		}else if(num1 instanceof Float || num2 instanceof Float){
			if(isDoubleOverflow(num1.doubleValue(),num2.doubleValue(),Float.MAX_VALUE,Float.MIN_VALUE)){
				return Double.valueOf(num1.doubleValue()+num2.doubleValue());
			}else{
				return Float.valueOf(num1.floatValue()+num2.floatValue());
			}
		}else if(num1 instanceof Long || num2 instanceof Long){
			  if(isLongOverflow(num1.longValue(), num2.longValue(), Long.MAX_VALUE, Long.MIN_VALUE)){
				  return BigInteger.valueOf(num1.longValue()).add(BigInteger.valueOf(num2.longValue()));
			  }else{
				  return Long.valueOf(num1.longValue()+num2.longValue());
			  }
		}else if(num1 instanceof Integer || num2 instanceof Integer){
			  if(isLongOverflow(num1.longValue(), num2.longValue(), Integer.MAX_VALUE, Integer.MIN_VALUE)){
				  return Long.valueOf(num1.longValue()+num2.longValue());
			  }else{
				  return Integer.valueOf(num1.intValue()+num2.intValue());
			  }
		}else if(num1 instanceof Short || num2 instanceof Short){
			  if(isLongOverflow(num1.longValue(), num2.longValue(), Short.MAX_VALUE, Short.MIN_VALUE)){
				  return Integer.valueOf(num1.intValue()+num2.intValue());
			  }else{
				  return Short.valueOf((short) (num1.shortValue()+num2.shortValue()));
			  }
		}else{
			if(isLongOverflow(num1.longValue(), num2.longValue(), Byte.MAX_VALUE, Byte.MIN_VALUE)){
				  return Short.valueOf((short) (num1.shortValue()+num2.shortValue()));
			  }else{
				  return Byte.valueOf((byte) (num1.byteValue()+num2.byteValue()));
			  }
		}
	}
    
	public static boolean isDoubleOverflow(double a, double b,double max,double min){
		double maxvalue = 0;
		if(a < 0 && b < 0){
			maxvalue = min;
		}else if(a > 0 && b > 0){
			maxvalue = max;
		}else{
			return false;
		}
		if(maxvalue - a > b){
			return true;
		}
		return false;
	}
	
	public static boolean isLongOverflow(long a, long b,long max,long min){
		double maxvalue = 0;
		if(a < 0 && b < 0){
			maxvalue = min;
		}else if(a > 0 && b > 0){
			maxvalue = max;
		}else{
			return false;
		}
		if(maxvalue - a > b){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(Sumation.sum(5,6.7));

	}

}
