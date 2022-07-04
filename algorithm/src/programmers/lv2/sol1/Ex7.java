package programmers.lv2.sol1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ex7 {

	public static int[] solution(int[] progresses, int[] speeds) {
		
		int count = 1;
		List<Integer> list = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<progresses.length; i++) {
			int day = (100-progresses[i])/speeds[i];
			if((100-progresses[i])%speeds[i]!=0) day+=1;
			q.offer(day);
		}
		
		int a = q.poll();
		while(!q.isEmpty()) {
			if(!q.isEmpty()&&a>=q.peek()){
				q.poll();
				count++; 
			}else {
				list.add(count);
				a=q.poll();
				count = 1;
			}	
		}
		list.add(count);
		int[] answer = new int[list.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}
	
}
