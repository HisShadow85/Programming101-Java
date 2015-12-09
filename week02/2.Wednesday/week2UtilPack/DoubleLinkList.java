package week2UtilPack;


public class DoubleLinkList<T> implements List<T>{
		
		private class Node{
			T item;
			Node next;
			Node prev;
			Node(T item,Node next,Node prev){
				this.item = item;
				this.next = next;
				this.prev = prev;
			}
		}
		
		Node head;
		Node tail;
		int currIndex;
		Node currNode;
		int size;
		
		@Override
		public void add(T item) {
			if(size == 0){
				head = tail = new Node(item,null,null);
			}
			else{
				tail = new Node(item,tail,null);
				tail.next.prev = tail;
			}
			
			size++;
			
		}
		
		@Override
		public void remove(int index) {
			if(index < 0 || index >=size){
				throw new IllegalArgumentException();
			}
			if(index == 0){
				if(size == 1){
					head = tail = currNode = null;
				}else{
					head = head.prev;
					head.next = null;
				}
			}
			else if(index == size - 1){
				tail = tail.next;
				tail.prev = null;
			}
			else if(index == currIndex){
				 Node temp = currNode;
				 currNode = currNode.next;
				 currIndex--;
				 temp.prev.next = temp.next;
				 temp.next.prev = temp.prev;
			}
			else{
				int start = getClosestIndex(index);
				int step = start - index > 0 ? -1: 1;
				Node temp;
				if(start == 0){
					temp = head;
				}
				else if(start == size -1){
					temp = tail;
				}
				else{
					temp = currNode;
				}
				
				while(start != index) {
					temp = step < 0 ? temp.next : temp.prev;
					start+=step;
				}
				
			     currNode = temp.prev;
				 currIndex = index;
				 temp.prev.next = temp.next;
				 temp.next.prev = temp.prev;
			}
			
			size--;
			
			updateCurr();
		
			
		}
		@Override
		public int size() {		
			return size;
		}
		@Override
		public T get(int elementIndex) {
			if(size == 0)return null;
			if(elementIndex == 0){
				return head.item;
			}
			else if(elementIndex == size -1){
				return tail.item;
			}
			else if(elementIndex == currIndex){
				return currNode.item;
			}
			else{
				int start = getClosestIndex(elementIndex);
				int step = start - elementIndex > 0 ? -1: 1;
				Node temp;
				if(start == 0){
					temp = head;
				}
				else if(start == size -1){
					temp = tail;
				}
				else{
					temp = currNode;
				}
				
				while(start != elementIndex) {
					temp = step < 0 ? temp.next : temp.prev;
					start+=step;
				}
				
				currNode = temp;
				currIndex = elementIndex;
				
				return currNode.item;
			}
		}
		@Override
		public T getHead() {
			return head.item;
		}
		@Override
		public T getTail() {
			return tail.item;
		}
		
		private int getClosestIndex(int index){
			
			if(index < abs(this.size - index -1)){
				return index < abs(this.currIndex - index) ? 0 : this.currIndex ;
			}
			else{
				return abs(this.size - index -1) < abs(this.currIndex - index) ? this.size -1 : this.currIndex;
			}
		}
		
		private int abs(int num){
			return num < 0 ? -num : num;
		}
		
		private void updateCurr(){
			if(currIndex > size -1){
				currNode = tail;
				currIndex = size -1;
			}
			else if(currIndex < 0){
				currNode = head;
				currIndex = 0;
			}
		}
}
