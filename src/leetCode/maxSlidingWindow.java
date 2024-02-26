package leetCode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class maxSlidingWindow {

	public static int[] maxSlidingWindow(int[] nums, int k) {

		int n = nums.length;
		int[] res = new int[n - k + 1];
		ArrayDeque<Integer> que = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {

			if (i >= k) {
				res[i - k] = que.peekFirst();
				if (nums[i - k] == que.peekFirst()) {
					que.pollFirst();
				}

			}
			while (!que.isEmpty() && que.peekLast() < nums[i]) {
				que.pollLast();
			}
			que.addLast(nums[i]);
		}

		res[n - k] = que.peekFirst();

		return res;

	}

	public static void main(String[] args) {

		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));

	}

}
