package leetCode;

import java.util.Arrays;

public class ProductExceptSelf {

	public static int[] productExceptSelf(int[] nums) {

		int n = nums.length;
		int[] res = new int[n];

		res[0] = 1;
		int multiply = 1;

		for (int i = 1; i < n; i++) {
			multiply *= nums[i - 1];
			res[i] = multiply;
		}

		multiply = 1;
		for (int i = n - 2; i >= 0; i--) {
			multiply *= nums[i + 1];
			res[i] = multiply * res[i];
		}

		return res;

	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(productExceptSelf(nums)));

	}

}
