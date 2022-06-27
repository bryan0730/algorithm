package programmers.lv1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
    
    //https://programmers.co.kr/learn/courses/30/lessons/12924
    public static int solution(int n) {
    	int answer = 0;
        
        for(int i=1; i<=n; i++) {
            int sum = 0;
            for(int j=i; j<=n; j++) {
                sum += j;
                
                if(sum==n) {
                    answer++;
                    break;
                } else if(sum>n) {
                    break;
                }
            }
        }      
        return answer;
    }
    
    //https://programmers.co.kr/learn/courses/30/lessons/42583
    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int time = 0;
        for(int i=0; i<truck_weights.length; i++) {
        	while(true) {
        		int truck = truck_weights[i];
        		if(q.isEmpty()) {
        			q.add(truck);
            		sum += truck;
            		time++;
            		break;
        		}else if(q.size()==bridge_length) {
        			sum -= q.poll();
        			
        		}else{
        			if(sum+truck <= weight) {
        				q.add(truck);
            			sum+=truck;
            			time++;
            			break;
        			}else {
        				q.add(0);
        				time++;
        			}
        		}
        	}
        }
        
        return time + bridge_length;
    }
    
    /*
     * 타겟 넘버(못풀었다 어렵다)
     * https://programmers.co.kr/learn/courses/30/lessons/43165?language=java 
     */
    public int solution(int[] numbers, int target) {
        int answer = 0;
        return answer;
    }
    
    
    
    //https://programmers.co.kr/learn/courses/30/lessons/42839
    boolean[] visited;
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
		visited = new boolean[numbers.length()];
		dfs(numbers, 0, "");
		return set.size();
	}
    
    public void dfs(String numbers, int depth, String current) {
    	if(depth == numbers.length()) return;
    	
    	
    	
    	for(int i=0; i<numbers.length(); i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			String number = current + numbers.charAt(i);
    			
    			if(isCheck(number)) {
    				int num = Integer.parseInt(number);
    				set.add(num);
    			}
    			dfs(numbers, depth+1, number);
    			visited[i] = false;
    		}
    	}
    }
    
    private boolean isCheck(String number) {
    	
    	int num = Integer.parseInt(number);
    	
    	for(int i=2; i*i<=num; i++) {
    		if(num%i==0) return false;
    	}
    	if(num <= 1) return false;
    	
    	return true;
    }
}
