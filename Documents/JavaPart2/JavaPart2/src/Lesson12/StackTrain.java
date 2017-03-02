package Lesson12;

import java.util.Arrays;

public class StackTrain implements iStack {
	private Vagon[] masVagon;
	private int top;

	public StackTrain(int size) {
		super();
		masVagon = new Vagon[size];
		top = -1;
	}

	void randFill() {
		while (!isFull()) {
			push(new Vagon((int) (Math.random() * 2)));
		}
	}

	public String toString() {
		return Arrays.toString(masVagon);
	}

	@Override
	public Vagon peek() {
		return masVagon[top];
	}

	@Override
	public void push(Vagon v) {
		if (!isFull()) {
			masVagon[++top] = v;
		}
	}

	@Override
	public Vagon pop() {

		return !isEmpty() ? masVagon[top--] : null;

	}

	@Override
	public boolean isEmpty() {
		return top < 0;

	}

	@Override
	public boolean isFull() {
		return top == masVagon.length - 1;
	}

	@Override
	public int capacity() {
		return masVagon.length - 1;
	}

	@Override
	public int size() {
		return top + 1;
	}

}
