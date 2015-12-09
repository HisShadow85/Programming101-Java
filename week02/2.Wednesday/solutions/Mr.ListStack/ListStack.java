package week2;

import week2UtilPack.DoubleLinkList;
import week2UtilPack.StackAPI;
import week2UtilPack.HashSet;

public class ListStack {

	static public <T> StackAPI<T> getListStack() {
		return new StackAPI<T>() {
			DoubleLinkList<T> list = new DoubleLinkList<T>();
			HashSet<T> hash = new HashSet<T>(153, 19473);

			@Override
			public void push(T item) {
				if (hash.insert(item)) {
					list.add(item);
				} else {
					throw new RuntimeException("No duplicates are allowed");
				}

			}

			@Override
			public T pop() {
				if (list.size() > 0) {
					T result = list.getTail();
					list.remove(list.size() - 1);
					hash.remove(result);
					return result;
				} else {
					return null;
				}
			}

			@Override
			public int size() {
				return list.size();
			}

		};
	}

	public static void main(String[] args) {
		StackAPI<Integer> stack = ListStack.<Integer>getListStack();
		for (int i = 0; i < 100; i++) {
			stack.push(i);
		}
		
		while(stack.size() != 0){
			System.out.print(stack.pop()+" ");
		}
		
		

	}

}
