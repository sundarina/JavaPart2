package Lesson12;

public class ParsePost {
	private stackL theStack;
	private String input;

	public ParsePost(String s) {
		input = s;
	}

	public int doParse() {
		theStack = new stackL(20);
		
		char ch;
		int j;
		int num1, num2, interAns;
		for (j = 0; j < input.length(); j++) {
			char[] c = input.toCharArray();
			ch = c[j];
			
			theStack.displayStack("");
			if (Character.isDigit(ch)) {
				theStack.push(Character.getNumericValue(ch));
				System.out.println(Character.getNumericValue(ch));
			} else if(ch == '+' || ch == '-'||ch == '*' || ch == '/'||ch == '('||ch == ')')  {
				
				num2 = theStack.pop();
				num1 = theStack.pop();
				switch (ch) {
				case '+':
					interAns = num1 + num2;
					break;
				case '-':
					interAns = num1 - num2;
					break;
				case '*':
					interAns = num1 * num2;
					break;
				case '/':
					interAns = num1 / num2;
					
					break;
				default:
					interAns = 0;
				}
				theStack.push(interAns);
			}

		}
		interAns = theStack.pop();
		return interAns;
	}

}
