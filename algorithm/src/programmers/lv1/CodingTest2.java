package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CodingTest2 {

	//https://programmers.co.kr/learn/courses/30/lessons/81301
	public int solution(String s) {
		
		String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
		
		for(int i=0; i<arr.length; i++) {
			s = s.replace(arr[i], Integer.toString(i));
		}
		
        int answer = Integer.parseInt(s);
        return answer;
    }
	
	//https://programmers.co.kr/learn/courses/30/lessons/67256
	public String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
		int left=10, right=12;
		int L_dis, R_dis;
		for(int n : numbers) {
			L_dis = 0; R_dis = 0;
			if(n == 1 || n == 4 || n == 7) {
				sb.append("L");
				left = n;
			
			}else if(n == 3 || n == 6 || n == 9) {
				sb.append("R");
				right = n;
			
			}else {
				if(n==0) n += 11;
				L_dis = (Math.abs(n-left))/3 + (Math.abs(n-left))%3;
				R_dis = (Math.abs(right-n))/3 + (Math.abs(right-n))%3;
				if(L_dis == R_dis) {
					if(hand.equals("right")) {
						sb.append("R");
						right = n;
					}else {
						sb.append("L");
						left = n;
					}
				}else if(L_dis > R_dis) {
					sb.append("R");
					right = n;
				}else {
					sb.append("L");
					left = n;
				}
			}
		}	
		return sb.toString();
    }
	
	public String solution2(int[] numbers, String hand) {
		String result = "";
		int lloc = 10;
		int rloc = 12;
		int[][] arr = {{0,0},{0,1},{0,2},
					   {1,0},{1,1},{1,2},
					   {2,0},{2,1},{2,2},
					   {3,0},{3,1},{3,2}};
		
		for(int i=0; i<numbers.length; i++) {
			int number = numbers[i];
			if(number%3==1) {
				result += "L";
				lloc = number;
			}else if(number%3==0){
				result += "R";
				rloc = number;
			}else {
				if(number==0) number+=11;
				
				int ldis = Math.abs(arr[lloc-1][0]-arr[number-1][0]) + Math.abs(arr[lloc-1][1]-arr[number-1][1]);
				int rdis = Math.abs(arr[rloc-1][0]-arr[number-1][0]) + Math.abs(arr[rloc-1][1]-arr[number-1][1]);
				if(ldis==rdis) {
					if(hand.equals("right")) {
						result += "R";
						rloc = number;
					}else {
						result += "L";
						lloc = number;
					}
				}else if(ldis>rdis) {
					result += "R";
					rloc = number;
				}else {
					result += "L";
					lloc = number;
				}
			}
		}
		
		return result;
	}
	
	//https://programmers.co.kr/learn/courses/30/lessons/64061
	public int solution(int[][] board, int[] moves) {
		
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=0; i<moves.length; i++) {
        	int move = moves[i];
        	for(int j=0; j<board.length; j++) {
        		int doll = board[j][move-1];
        		if(doll!=0) {
        			if(stack.peek()==doll) {
        				stack.pop();
        				answer++;
        			}else {
        				stack.push(doll);
        				
        			}
        			board[j][move-1] = 0;
        			break;
        		}
        	}
        }
        return answer*2;
    }
	
	//https://programmers.co.kr/learn/courses/30/lessons/12977?language=java
	public int solution(int[] nums) {
        int answer = 0;

        for(int i=0; i<nums.length-2; i++) {
        	for(int j=i+1; j<nums.length-1; j++) {
        		for(int k=j+1; k<nums.length; k++) {
        			int sum = nums[i]+nums[j]+nums[k];
        			if(isCheck(sum)) {
        				answer++;
        			}
        		}
        	}
        }

        return answer;
    }
	
	private boolean isCheck(int number) {
		
		if(number <= 1) return false;
		
		for(int i=2; i*i<=number; i++) {
			if(number%i==0) return false;
		}
		
		return true;
	}
	
	//https://programmers.co.kr/learn/courses/30/lessons/42576
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> map = new HashMap<>();
		for(String name : participant) {
			map.put(name, map.getOrDefault(name, 0)+1);
		}
		
		for(String name : completion) {
			map.put(name, map.get(name)-1);
		}
		
		for(String key : map.keySet()) {
			if(map.get(key)!=0) {
				answer = key;
			}
		}
		
		return answer;
	}
	
	//https://programmers.co.kr/learn/courses/30/lessons/42748
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for(int i=0; i<commands.length; i++) {
			List<Integer> list = new ArrayList<>();
			for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
				list.add(array[j]);
				
			}
			Collections.sort(list);
			answer[i] = list.get(commands[i][2]-1);
		}
		
		return answer;
	}
	
	//https://programmers.co.kr/learn/courses/30/lessons/42840
	 public static int[] solutions(int[] answers) {
		 
		 int[] first = {1,2,3,4,5};
	     int[] second = {2,1,2,3,2,4,2,5};
	     int[] third = {3,3,1,1,2,2,4,4,5,5};
	     
	     int[] score = {0,0,0};
	     
	     for(int i=0; i<answers.length; i++) {
	    	 if(first[i%5]==answers[i]) score[0]++;
	    	 if(second[i%8]==answers[i]) score[1]++;
	         if(third[i%10]==answers[i]) score[2]++;
	     }
	     
	     int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
	     List<Integer> list = new ArrayList<>();
	     
	     for(int i=0; i<score.length; i++) {
	    	 if(maxScore==score[i]) list.add(i+1);
	     }
		 int[] result = new int[list.size()];
	     for(int i=0; i<result.length; i++) {
	    	 result[i] = list.get(i);
	     }
		 return result;
	 }
	 
	 //정확도 66점 다시풀어야 함
	 //https://programmers.co.kr/learn/courses/30/lessons/42862
	 public int solution(int n, int[] lost, int[] reserve) {
	        Arrays.sort(lost);
	        Arrays.sort(reserve);
	        int answer = 0;
	        boolean[] visited = new boolean[reserve.length];
	        int pos = n-lost.length;
	        
	        for(int i=0; i<lost.length; i++){
	            int los = lost[i];
	            for(int j=0; j<reserve.length; j++){
	               if(visited[j]) continue;
	                if(reserve[j]-1 == los || reserve[j]+1 == los){
	                	visited[i] = true;
	                    answer++;
	                    break;
	                }
	            }
	        }
	        
	        return answer+pos;
	    }
	 
	//https://programmers.co.kr/learn/courses/30/lessons/1845
	public int solution2(int[] nums) {
		 
		HashSet<Integer> set = new HashSet<>();
		 for(int p : nums) {
			 set.add(p);
		 }
		 
		 int choice = nums.length/2;
		 
		 if(set.size()>=choice) 
			 return choice;
		 else 
			 return set.size();
	}
	
	//https://programmers.co.kr/learn/courses/30/lessons/42889?language=java
	public int[] solution(int N, int[] stages) {
        
		int[] answer = new int[N];
        Map<Integer, Double> map = new HashMap<>();
		
		for(int i=1; i<=N; i++) {
			double nonClear = 0;
	        double arrive = 0;
			for(int j=0; j<stages.length; j++) {
				if(i<=stages[j]) arrive++;
				if(i==stages[j]) nonClear++;
			}
			
			if(arrive != 0)
				map.put(i, nonClear/arrive);
			else
				map.put(i, 0.0);
		}

		for(int i=0; i<N; i++) {
			
			double max = -1;
			int maxKey = 0;
			
			for(int key : map.keySet()) {
				if(max<map.get(key)) {
					max= map.get(key);
					maxKey = key;
				}
			}
			answer[i] = maxKey;
			map.remove(maxKey);
		}
		
        return answer;
    }
	

}
