package Lesson12;

public interface iStack {

	Vagon peek();

	void push(Vagon v);

	Vagon pop();

	boolean isEmpty();

	boolean isFull();

	int capacity();

	int size();

}