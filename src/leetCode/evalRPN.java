package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class evalRPN {

	public static int evalRPN(String[] tokens) {

		Deque<Integer> stack = new ArrayDeque<>();
		String operator = "+-*/";
		for (String token : tokens) {

			if (!operator.contains(token)) {
				stack.push(Integer.parseInt(token));
			} else {
				int n2 = stack.pop();
				int n1 = stack.pop();

				if (token.equals("+")) {
					stack.push(n1 + n2);
				} else if (token.equals("-")) {
					stack.push(n1 - n2);
				} else if (token.equals("/")) {
					stack.push(n1 / n2);
				} else if (token.equals("*")) {
					stack.push(n1 * n2);
				}
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		
		String[] tokens = {"2", "1", "+", "3", "*"}; 
		System.out.println(evalRPN(tokens));
		
		String[] testTokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}; 
		System.out.println(evalRPN(testTokens));
	}

}
