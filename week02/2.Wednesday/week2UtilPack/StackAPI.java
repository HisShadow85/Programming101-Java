package week2UtilPack;

public interface StackAPI<T> {
	void push(T item);
	T pop();
	int size();
}
