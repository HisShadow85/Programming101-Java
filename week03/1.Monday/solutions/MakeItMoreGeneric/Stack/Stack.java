package week2UtilPack;

public class Stack<T> implements StackAPI<T> {
	class Node{
		T item;
		Node next;
		
		Node(T item, Node prev){
			this.item = item;
			next = prev;
		}
		
		
	}
	int size_= 0;
	Node top = null; 
	
	public void push(T item){	
		top = new Node(item,top);
		size_++;
	}
	
	public T pop(){
		if(top == null) return null;
		T result = top.item;
		size_--;
		top = top.next;
		return result;
	}
	
	public int size(){
		return size_;
	}
	

}


