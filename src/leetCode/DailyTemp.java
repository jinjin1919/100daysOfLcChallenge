package leetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemp {

	public static int[] dailyTemperatures(int[] temperatures) {

		Deque<int[]> stack = new ArrayDeque<>();
		int n = temperatures.length;
		int[] res = new int[n];

		for (int i = 0; i < n; i++) {
			int temp = temperatures[i];
			while (!stack.isEmpty() && stack.peek()[0] < temp) {
				int[] curr = stack.pop();
				res[curr[1]] = i - curr[1];
			}

			stack.push(new int[] { temp, i });
		}

		return res;
	}

	public static void main(String[] args) {
		
		int[] temps = {73,74,75,71,69,72,76,73}; 
		System.out.println(Arrays.toString(dailyTemperatures(temps)));

	}

}
