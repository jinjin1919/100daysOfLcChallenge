package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {10,1,2,7,6,1,5}; 
		System.out.println(combinationSum2(candidates, 8));

	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		backtracking(res, new ArrayList<>(), candidates, target, 0);

		return res;
	}

	public static void backtracking(List<List<Integer>> res, List<Integer> curr, int[] candi, int target, int start) {

		if (target == 0) {
			res.add(new ArrayList<>(curr));
			return;
		}

		if (start == candi.length) {
			return;
		}

		for (int i = start; i < candi.length; i++) {
			if (i != start && candi[i] == candi[i - 1]) {
				continue;
			}

			if (target - candi[i] >= 0) {
				curr.add(candi[i]);
				backtracking(res, curr, candi, target - candi[i], i + 1);
				curr.remove(curr.size() - 1);
			}
		}
	}

}
