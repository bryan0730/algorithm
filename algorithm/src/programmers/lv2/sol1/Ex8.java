package programmers.lv2.sol1;

import java.util.PriorityQueue;

public class Ex8 {

	//https://programmers.co.kr/learn/courses/30/lessons/42626
	public static int solution(int[] scoville, int K) {
		
		int answer = 0;
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0; i<scoville.length; i++) {
			q.offer(scoville[i]);
		}
		
		int sco = 0;
		while(sco<K) {
			if(q.size()<2) return -1;
			answer++;
			sco = q.poll() + q.poll()*2;
			q.offer(sco);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}
}
