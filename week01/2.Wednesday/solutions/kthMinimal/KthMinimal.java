package week1;

public class KthMinimal {

	public static void main(String[] args) {
		int[] a = {6,7,3,2,1,4,0,9,8,5};
		System.out.println("The 5 min is: "+ kthMin(5,a));
		System.out.println("The 6 min is: "+ kthMin(6,a));
		System.out.println("The 1 min is: "+ kthMin(1,a));

	}

	static int kthMin(int k, int[] array) {
		int leftBound = 0;
		int rightBound = array.length-1;
		int left = 0;
		int right = array.length - 2;
		while (left<=right) {
			int pivot = setPivot(array, left, rightBound);
			while (left < right) {
				while (array[left] < pivot) {
					left++;
				}
				while (right >= 0 && array[right] > pivot) {
					right--;
				}
				if (left >= right)
					break;
				swap(array, left, right);
			}
			//put the pivot to it's proper place
			swap(array, left, rightBound);
			//in the index is 5 that means 6th element so if k is 5
			if (left >= k) { //then k is still into the left part
               rightBound = left;
               right = left-1;
               left = leftBound;
			}else if(k > left+1){//index(5) + 1 means 7th element
				leftBound = left+1;
				right = rightBound-1;
				left = leftBound;
			}else{
				return pivot;
			}
		}
		return right;
	}

	static int setPivot(int[] arr, int left, int right) {
		int mid = left + ((right - left) >> 1);
		compexchange(arr, left, mid);
		compexchange(arr, left, right);
		compexchange(arr, right, mid);
		return arr[right];
	}

	static void compexchange(int[] arr, int first, int second) {
		if (arr[first] > arr[second]) {
			swap(arr, first, second);
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
