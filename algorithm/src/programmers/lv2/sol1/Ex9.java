package programmers.lv2.sol1;

public class Ex9 {

	//https://programmers.co.kr/learn/courses/30/lessons/43165
	static int count;
	public static int solution(int[] numbers, int target) {
		
		int answer = 0;
		
		com(0, 0, numbers, new boolean[numbers.length], target, 0);
		answer = count;
		return answer;
	}
	
	public static void com(int depth, int start, int[] numbers, boolean[] visited, int target, int sum) {
		
		if(depth==numbers.length) {
			if(sum==target) count++;
			return;
		}
		
		for(int i=start; i<numbers.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				com(depth+1, i+1, numbers, visited, target, sum+numbers[depth]);
				com(depth+1, i+1, numbers, visited, target, sum-numbers[depth]);
				visited[i] = false;
			}
		}
	}
	
	public static void dfs(int[] numbers, int depth, int target, int sum) {
		
		if(depth == numbers.length) {
			if(sum==target) count++;
			return;
		}
		
		dfs(numbers, depth+1, target, sum+numbers[depth]);
		dfs(numbers, depth+1, target, sum-numbers[depth]);
		
	}
	
	public static void main(String[] args) {
		
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
}
