package week2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

final class Pair<T>{
	private final T first;
	private final T second;
	
	Pair(T first , T second) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
	    
		this.first = first;
		this.second = second;
		/*
		//Pair.class.asSubclass(Pair.class).getConstructor(String.class).newInstance("howdy");
		Class<?> clazz =  first.getClass();
		
		String className = clazz.getName();
		Constructor<?> ctor = clazz.asSubclass(clazz).getConstructor(clazz); ///clazz.getConstructor(clazz);
		Object object = ctor.newInstance(new Object[] { first});
		this.first = (T) object ;
		object = ctor.newInstance(new Object[] { second});
		this.second = (T) object ;
		*/
		
	}
	
	public T getFirst(){
		return first;
	}
	
	public T getSecond(){
		return  second;
	}
	
	public boolean equal(Object other){
		if(other == null) return false;
		if(this == other) return true;
		if(!(other instanceof Pair<?>)){
			return false;
		}
		
		Pair<T> otherPair = (Pair<T>)other;
		if( first.equals(otherPair.first) && second.equals(otherPair.second)){
			return true;
		}
		if( second.equals(otherPair.first) && first.equals(otherPair.second)){
			return true;
		}
		return false;
	}
	
}
public class PairEmUp {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuilder sb1 = new StringBuilder("az sam 1");
		StringBuilder sb2 = new StringBuilder("az sam 2");
		Pair<StringBuilder> pair = new Pair<>(sb1,sb2);
		
		System.out.println("D:A");
	}
    
}
