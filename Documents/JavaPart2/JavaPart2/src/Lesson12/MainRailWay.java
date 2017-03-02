package Lesson12;

import java.util.Stack;

public class MainRailWay {
	public static void manualStack() {
		StackTrain fullTrain = new StackTrain(10);
		fullTrain.randFill();
		StackTrain passTrain = new StackTrain(10);
		StackTrain cargoTrain = new StackTrain(10);
		System.out.println(fullTrain);
		while (!fullTrain.isEmpty()) {
			if (fullTrain.peek().getId() == 0) {
				passTrain.push(fullTrain.pop());
			} else {
				cargoTrain.push(fullTrain.pop());
			}
		}
		System.out.println(passTrain);
		System.out.println(cargoTrain);
	}

	public static void main(String[] args) {
		Stack<Vagon> fullTrain = new Stack<>();
		
		for(int i = 0; i < 10;i++) {
			fullTrain.push(new Vagon((int) (Math.random() * 2)));
		}
	
		Stack<Vagon> passTrain = new Stack<>();
		Stack<Vagon> cargoTrain = new Stack<>();
		System.out.println(fullTrain);
		while (!fullTrain.isEmpty()) {
			if (fullTrain.peek().getId() == 0) {
				passTrain.push(fullTrain.pop());
			} else {
				cargoTrain.push(fullTrain.pop());
			}
		}
		System.out.println(passTrain);
		System.out.println(cargoTrain);

	}
}
