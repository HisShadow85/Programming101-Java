package week2UtilPack;

public class UniqueStack<T> extends Stack<T>{
	HashSet<T> hashSet = new HashSet<T>(153,19823);

	public void push(T item) {
		if (hashSet.insert(item)) {
			super.push(item);
		} else {
			throw new RuntimeException("This element alredy exists!");
		}

	}
	
	public T pop(){
		T temp = super.pop();
		if( temp != null){
			hashSet.remove(temp);
		}
		return temp;
	}
}
