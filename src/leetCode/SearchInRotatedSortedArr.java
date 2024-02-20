package leetCode;

public class SearchInRotatedSortedArr {

	public static int search(int[] nums, int target) {

		int n = nums.length - 1;
		int left = 0;
		int right = n;

		while (left <= right) {

			int mid = (left + right) / 2;
			if (target == nums[mid])
				return mid;
			if (nums[left] <= nums[mid]) {
				if (target >= nums[left] && target <= nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (target >= nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,5,6,7,0,1,2}; 
		System.out.println(search(nums, 0));
	}

}
