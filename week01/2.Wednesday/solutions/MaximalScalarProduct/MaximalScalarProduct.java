package week1;

public class MaximalScalarProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3};
		int[] b = {1,2,3};
		
        System.out.println(maximalScalarProduct(a,b));
        
	}
     
	static long maximalScalarProduct(int[] a , int[] b){
		if(a.length < 3 || b.length < 3) { return 0;}
		heapsort(a, a.length);
		heapsort(b, b.length);
		long msp = 0;
		
		for (int i = 0; i < b.length; i++) {
			msp+=a[i]*b[i];
		}
		
		return msp;
		
	}
	
	static void heapsort(int[] a, int count) {
		// input: an unordered array a of length count

		// (Build the heap in array a so that largest value is at the root)
		heapify(a, count);

		// (The following loop maintains the invariants that a[0:end] is a heap
		// and every element
		// beyond end is greater than everything before it (so a[end:count] is
		// in sorted order))
		int end = count - 1;
		while (end > 0) {
			// (a[0] is the root and largest value. The swap moves it in front
			// of the sorted elements.)
			swap(a, end, 0);
			// (the heap size is reduced by one)
			end = end - 1;
			// (the swap ruined the heap property, so restore it)
			siftDown(a, 0, end);
		}
	}

	// (Put elements of 'a' in heap order, in-place)

	static void heapify(int[] a, int count) {
		// (start is assigned the index in 'a' of the last parent node)
		// (the last element in a 0-based array is at index count-1; find the
		// parent of that element)
		int start = (count - 2) / 2;

		while (start >= 0) {
			// (sift down the node at index 'start' to the proper place such
			// that all nodes below
			// the start index are in heap order)
			siftDown(a, start, count - 1);
			// (go to the next parent node)
			start = start - 1;
		}
		// (after sifting down the root all nodes/elements are in heap order)
	}

	static void siftUp(int[] a, int start, int end) {
		// input: start represents the limit of how far up the heap to sift.
		// end is the node to sift up.
		int child = end;
		while (child > start) {
			int parent = (child - 1) / 2;
			if (a[parent] < a[child])// then out of max-heap order
			{
				swap(a, parent, child);
				child = parent; // repeat to continue sifting up the parent now
			} else
				return;
		}
	}

	static void siftDown(int[] a, int start, int end) {
		int root = start;

		while ((root * 2 + 1) <= end) { // (While the root has at least one
										// child)
			int child = root * 2 + 1; // (Left child)
			int toSwap = root; // (Keeps track of child to swap with)

			if (a[toSwap] < a[child])
				toSwap = child;
			// (If there is a right child and that child is greater)
			if ((child + 1 <= end) && (a[toSwap] < a[child + 1]))
				toSwap = child + 1;
			if (toSwap == root)
				// (The root holds the largest element. Since we assume the
				// heaps rooted at the
				// children are valid, this means that we are done.)
				return;
			else
				swap(a, root, toSwap);
			root = toSwap; // (repeat to continue sifting down the child now)
		}
	}

	

	static void swap(int[] arr, int first, int second) {
		if (arr[first] != arr[second]) {
			arr[first] ^= arr[second];
			arr[second] ^= arr[first];
			arr[first] ^= arr[second];
		}
	}
	
}
