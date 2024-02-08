package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKSolution {

	public static void main(String[] args) {
		
		int[] arr1 = {1,1,1,2,2,3}; 
		int[] res1 = topKFrequent(arr1, 2); 
		
		
		System.out.println(Arrays.toString(res1));

	}

	public static int[] topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			que.offer(entry);
			if (que.size() > k) {
				que.poll();
			}
		}

		int[] res = new int[k];

		int i = 0;
		while (!que.isEmpty()) {
			res[i++] = que.poll().getKey();
		}

		return res;
	}

}
