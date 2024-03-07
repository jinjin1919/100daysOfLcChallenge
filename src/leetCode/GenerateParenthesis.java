package leetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {

		List<String> res = new ArrayList<>();
		backtrack(res, new StringBuilder(), 0, 0, n);
		return res;

	}

	public void backtrack(List<String> res, StringBuilder sb, int left, int right, int n) {

		if (left == right && left == n) {
			res.add(sb.toString());
			return;
		}

		if (left != n) {
			sb.append("(");
			backtrack(res, sb, left + 1, right, n);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (left > right) {
			sb.append(")");
			backtrack(res, sb, left, right + 1, n);
			sb.deleteCharAt(sb.length() - 1);
		}

	}

	public static void main(String[] args) {
		
		GenerateParenthesis gp = new GenerateParenthesis(); 
		System.out.println(gp.generateParenthesis(3));
		
	}

}
