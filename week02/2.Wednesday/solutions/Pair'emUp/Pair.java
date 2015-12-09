package week2;

import java.lang.reflect.InvocationTargetException;

final public class Pair<K,V> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private final K key;
	private final V value;
	
	public Pair(K key , V value) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
	    
		this.key = key;
		this.value = value;
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
	
	public K getKey(){
		return key;
	}
	
	public V getValue(){
		return  value;
	}
	
	public V getValue(K key){
		if(this.key.equals(key)){
			return value; 			
		}
		return null;
		
	}
	
	public boolean equal(Object other){
		if(other == null) return false;
		//if(this == other) return true;
		if(!(other instanceof Pair)){
			return false;
		}
		Pair<K,V> otherPair;
		try{
		    otherPair = (Pair<K,V>)other;
		}catch(Exception e){
			return false;
		}
		if( key.equals(otherPair.key) && value.equals(otherPair.value)){
			return true;
		}

		return false;
	}

}