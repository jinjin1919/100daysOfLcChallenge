package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
	
	class Element {

        String value; 
        int timeStamp; 

        public Element(String val, int t) {
            this.value = val; 
            this.timeStamp = t; 
        }
    }
    Map<String, List<Element>> cache; 

    public TimeMap() {
        cache = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        cache.computeIfAbsent(key, k -> new ArrayList<>()).add(new Element(value, timestamp)); 
    }
    
    public String get(String key, int timestamp) {
        
        if(!cache.containsKey(key)) return ""; 

        List<Element> lst = cache.get(key); 
        if(lst.size() == 0) return ""; 

        if(timestamp < lst.get(0).timeStamp) return ""; 


        int left = 0; 
        int right = lst.size() - 1; 

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(lst.get(mid).timeStamp == timestamp){
                return lst.get(mid).value; 
            }

            if(lst.get(mid).timeStamp < timestamp) {
                left = mid+1; 
            } else {
                right = mid-1; 
            }
        }

        return left < lst.size()? lst.get(left-1).value: lst.get(lst.size()-1).value; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeMap timeMap = new TimeMap(); 
		timeMap.set("foo", "bar", 1);
		System.out.println(timeMap.get("foo", 1));
		System.out.println(timeMap.get("foo", 3));
		timeMap.set("foo", "bar2", 4);
		System.out.println(timeMap.get("foo", 4));
		System.out.println(timeMap.get("foo", 5));
	}

}
