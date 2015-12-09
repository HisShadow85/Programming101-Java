package week2UtilPack;

public interface List<T> {
	void add(T item);
	void remove(int index);
	int size();
	T get(int elementIndex);
	T getHead();
	T getTail();
}
