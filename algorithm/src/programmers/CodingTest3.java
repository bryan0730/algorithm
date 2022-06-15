package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CodingTest3 {

	//https://programmers.co.kr/learn/courses/30/lessons/77884
	public int solution(int left, int right) {
		
        int answer = 0;
        
        for(int i=left; i<=right; i++) {
        	int count = 0;
        	for(int j=1; j<=i; j++) {
        		if(i%j==0) count++;
        	}
        	
        	if(count%2==0) answer+=i;
        	else answer-=i;
        }
        
        return answer;
    }
	
	//https://programmers.co.kr/learn/courses/30/lessons/68935
	public int solution(int n) {
        
		int answer = 0;
        
        String three = Integer.toString(n, 3);
        
        StringBuilder sb = new StringBuilder(three);
        answer = Integer.parseInt(sb.reverse().toString(), 3);
        
        return answer;
    }
	
	//https://programmers.co.kr/learn/courses/30/lessons/12982
	public int solution(int[] d, int budget) {
		
		int answer = 0;
		int sum = 0;
		
		Arrays.sort(d);
		
		for(int i=0; i<d.length; i++) {
			sum+=d[i];
			if(sum>budget) break;
			
			answer++;
		}
		
		return answer;
	}
	
	//https://programmers.co.kr/learn/courses/30/lessons/68644
	public int[] solution(int[] numbers) {
        
        List<Integer> list = new ArrayList<>();
		for(int i=0; i<numbers.length-1; i++) {
			int sum = 0;
			for(int j=i+1; j<numbers.length; j++) {
				sum = numbers[i]+numbers[j];
				if (!list.contains(sum)) {
					list.add(sum);
				}
			}
		}
		int[] answer = new int[list.size()];
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
	
	
	
	public static void main(String[] args) {
		int n = 45;
		String a = Integer.toString(n, 3);
		System.out.println(a);
	}
}
