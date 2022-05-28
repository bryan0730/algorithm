package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CodingTest {

	//https://programmers.co.kr/learn/courses/30/lessons/92334?language=java
    public int[] solution(String[] id_list, String[] report, int k) {
        
    	int[] answer = {};
    	answer = new int[id_list.length];
    	
    	Map<String, HashSet<String>> map = new HashMap<>(); //[신고된ID, [신고한 ID]]
    	Map<String, Integer> map2 = new HashMap<>(); // [신고된 Id, 메일 수]
    	
    	for(int i=0; i<id_list.length; i++) {
    		HashSet<String> reportingId = new HashSet<>();
    		map.put(id_list[i], reportingId);
    		map2.put(id_list[i], 0);
    	}
    	
    	for(int j=0; j<report.length; j++) {
    		String[] arr = report[j].split(" ");
    		map.get(arr[1]).add(arr[0]);
    	}
    	
    	for(String reportedUser : map.keySet()) {
    		HashSet<String> user = map.get(reportedUser);
    		if(user.size() >= k) {
    			for(String userId : user) {
    				map2.put(userId, map2.get(userId)+1);
    			}
    		}
    	}
    	
    	for(int i=0; i<id_list.length; i++) {
    		answer[i] = map2.get(id_list[i]);
    		System.out.println(answer[i]);
    	}
    	
    	return answer;
    }
    
    //https://programmers.co.kr/learn/courses/30/lessons/77484?language=java
    public static int[] solution(int[] lottos, int[] win_nums) {
        
        int rightNumber = 0;
        int zeroNumber = 0;
        
        for(int i=0; i<lottos.length; i++) {
        	int a = lottos[i];
        	if(a==0) zeroNumber++;
        	
        	for(int j=0; j<win_nums.length; j++) {
        		if(a==win_nums[j]) rightNumber++;
        	}
        }
        
        int min = rightNumber;
        int max = rightNumber + zeroNumber;
        
        int[] answer = {Math.min(7 - max, 6), Math.min(7 - min, 6)};
        
        return answer;
    }
	
    public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19}; 
		
		int ab  = 0;
		solution(lottos, win_nums);
	}
}
