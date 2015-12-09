package week2;

import week2UtilPack.Stack;;


public class StackImpl<T> extends Stack<T>{
    	
	public static void main(String[] args) {
		StackImpl<Integer> stack = new StackImpl<Integer>();
		stack.push(5);stack.push(6);stack.push(7);stack.push(8);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

}
