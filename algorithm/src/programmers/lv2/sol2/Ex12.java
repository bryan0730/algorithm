package programmers.lv2.sol2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Ex12 {

	//https://school.programmers.co.kr/learn/courses/30/lessons/72411
	static Map<String, Integer> map;
	public String[] solution(String[] orders, int[] course) {
		
		for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
		
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<course.length; i++) {
        	map = new HashMap<>();
        	int max = 0;
        	for(int j=0; j<orders.length; j++) {
        		if(course[i]>orders[j].length()) continue;
        		com(orders[j], 0, course[i], 0, new StringBuilder());
        	}
        	
        	
        	for(Entry<String, Integer> a : map.entrySet()) {
        		max = Math.max(max, a.getValue());
        	}
        	
        	for(Entry<String, Integer> a : map.entrySet()) {
        		if(max==a.getValue() && max>=2) list.add(a.getKey());
        	}
        }
        
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	
	public static void com(String order, int depth, int r, int start, StringBuilder sb) {
		
		if(depth==r) {
			map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
			return;
		}
		
		for(int i=start; i<order.length(); i++) {
			sb.append(order.charAt(i));
			com(order, depth+1, r, i+1, sb);
			sb.delete(depth, depth+1);
		}
	}
	
}
