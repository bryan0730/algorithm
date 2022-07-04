package programmers.lv2.sol1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ex4 {

	//https://programmers.co.kr/learn/courses/30/lessons/1835
	static int answer = 0;
	static String[] d;
	static Map<Character, Integer> map;
	public static int solution(int n, String[] data) {
		
		d = data;
		
		map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('F', 2);
		map.put('J', 3);
		map.put('M', 4);
		map.put('N', 5);
		map.put('R', 6);
		map.put('T', 7);
		
		permutation(new boolean[8], 0, new int[8]);
		
		return answer;
	}
	
	public static void permutation(boolean[] visited, int depth, int[] out) {
		
		if(depth == visited.length) {
			//조건 만족하는지 확인해야함
			//그리고 count++?
			if(isCheck(out)) {
				answer++;
			}
			return;
		}
		
		for(int i=0; i<visited.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				out[depth] = i;
				permutation(visited, depth+1, out);
				visited[i] = false;
			}
		}
	}
	
	public static boolean isCheck(int[] out) {
		
		for(String a : d) {
			int friend1 = out[map.get(a.charAt(0))];
			int friend2 = out[map.get(a.charAt(2))];
			char op = a.charAt(3);
			int num = a.charAt(4)-'0' + 1;
			
			int distance = Math.abs(friend1-friend2);
			if(op=='=') {
				if(distance!=num) return false;
			}else if(op=='>') {
				if(distance<=num) return false; 
			}else {
				if(distance>=num) return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		System.out.println(solution(n, data));
	}
}
