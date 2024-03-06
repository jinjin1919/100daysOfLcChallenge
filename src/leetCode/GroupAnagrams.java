package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			int[] freq = new int[26];
			for (char ch : str.toCharArray()) {
				freq[ch - 'a']++;
			}
			String key = Arrays.toString(freq);
			// System.out.println(key);
			map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
		}

		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		
		String[] strs = {"eat","tea","tan","ate","nat","bat"};  
		System.out.println(groupAnagrams(strs));

	}

}
