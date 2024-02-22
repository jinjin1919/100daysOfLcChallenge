package leetCode;

public class FindDuplicate {

	public static int findDuplicate(int[] nums) {

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {

			int mid = (left + right) / 2;

			int count = 0;
			for (int num : nums) {
				if (num <= mid) {
					count++;
				}
			}

			if (count <= mid) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return right;
	}
	public static void main(String[] args) {
		
		int[] nums = {1, 3, 4, 2, 2}; 
		System.out.println(findDuplicate(nums));
		
	}

}
