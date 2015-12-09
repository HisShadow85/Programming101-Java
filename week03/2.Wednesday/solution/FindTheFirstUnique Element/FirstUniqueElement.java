package week3;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;

public class FirstUniqueElement {

	public static void main(String[] args) {
		Collection<Integer> ints = Arrays.asList(1,2,3,4,5,5,4,3,1,6);
		System.out.println(getFirstUniqueElement(ints));

	}

	static public <T> T getFirstUniqueElement(Collection<T> list) {
		LinkedHashSet<T> set = new LinkedHashSet<>();
		for (T item : list) {
			if (set.contains(item)) {
				set.remove(item);
			} else {
				set.add(item);
			}
		}
		return set.iterator().next();

	}

}
