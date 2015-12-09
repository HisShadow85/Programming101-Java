package week2;

abstract class Car{
	
	
	boolean isEcoFriendly(boolean testing){
		     return true;
	}

	
	
	
}

abstract class GermanCar extends Car{
	   protected int mileage = 0;
}

class Audi extends GermanCar{
     public int getMileage(){
    	 return mileage;
     }
	
}

class BMW extends GermanCar{
	
	
}

class Volkswagen extends GermanCar{
	@Override
	boolean isEcoFriendly(boolean testing){
	    
		return testing;
}
}

class Honda extends Car{
	
}

class Skoda extends Car{
	
}


public class FastAndFurious {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    
}
