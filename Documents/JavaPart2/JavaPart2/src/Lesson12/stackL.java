package Lesson12;

public class stackL {
	private int maxSize;
	private int[] stackArray;
	private int top = -1;

	public stackL(int s) {
		maxSize = s;
		stackArray = new int[maxSize];

	}

	public void push(int j) {
		stackArray[++top] = j;
	}

	public int pop() {
		return stackArray[top--];
	}

	public int peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public int size() {
		return top + 1;
	}

	public int peekN(int n) {
		return stackArray[n];
	}

	public void displayStack(String s) {
		System.out.print(s);
		System.out.print("Stack (botton-->top): ");
		for (int j = 0; j < size(); j++) {
			System.out.print(peekN(j));
			System.out.print(',');

		}
		System.out.println("");
	}

}
