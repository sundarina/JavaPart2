package Lesson12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class infixApp {

	public static void main(String[] args) throws IOException {
		String input;
		int output;
		while (true) {
			System.out.println("Enter infix: ");
			System.out.flush();
			input = getString();
			if (input.equals("")) {
				break;
			}
			InToPost in = new InToPost(input);
			input = in.doTrans();
			char[] p = input.toCharArray();
			for (int i = 0; i < p.length; i++) {
				if(Character.getNumericValue(p[i]) != -1)
					System.out.println(p[i]);
				

			}
			ParsePost theTrans = new ParsePost(input);
			output = theTrans.doParse();
			System.out.println(output);

		}

	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		System.out.println("got string " + s);
		return s;
	}

}
