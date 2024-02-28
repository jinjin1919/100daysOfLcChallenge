package leetCode;

import java.util.ArrayList;
import java.util.List;

public class EncodeStrDecodeStr {

	public String encode(List<String> strs) {

		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			sb.append(str.length()).append("/").append(str);
		}

		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {

		List<String> res = new ArrayList<>();
		int idx = 0;
		int start = 0;
		while (idx != -1) {
			idx = s.indexOf("/", start);
			if (idx == -1)
				break;
			int len = Integer.parseInt(s.substring(start, idx));
			start = idx + 1;
			res.add(s.substring(start, start + len));
			start = start + len;
		}

		return res;

	}

	public static void main(String[] args) {
		
		EncodeStrDecodeStr codec = new EncodeStrDecodeStr(); 
		List<String> strs = new ArrayList<>(); 
		strs.add("Hello"); 
		strs.add("World"); 
		
		System.out.println(codec.decode(codec.encode(strs)));

	}

}
