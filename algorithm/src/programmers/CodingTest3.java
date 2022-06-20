package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//https://programmers.co.kr/learn/courses/30/lessons/12901
	public static String solution2(int a, int b) {
		
		String answer = "";
		String[] week = {"FIR", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
		int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int day = 0;
		for(int i=0; i<a-1; i++) {
			day += days[i];
		}
		day += (b-1);
		
        answer = week[day%7];
        
        return answer;
    }
	
	//https://programmers.co.kr/learn/courses/30/lessons/86491
	public int solution(int[][] sizes) {
		
		int answer = 0;
		int maxX = 0;
		int maxY = 0;
		for(int i=0; i<sizes.length; i++) {
			int x = Math.max(sizes[i][0], sizes[i][1]);
			int y = Math.min(sizes[i][0], sizes[i][1]);
			maxX = Math.max(maxX, x);
			maxY = Math.max(maxY, y);
		}
		answer = maxX * maxY;
		
		return answer;
	}
	
	//https://programmers.co.kr/learn/courses/30/lessons/82612
	public static long solution(int price, int money, int count) {
		
		long answer = 0;
		long sum = 0;
		
		for(int i=1; i<=count; i++) {
			sum += price*i;
		}
		
		if(sum>money) {
			answer = sum - money;
		}else {
			answer = 0;
		}
		
		return answer;
	}
	
	
	//https://programmers.co.kr/learn/courses/30/lessons/42888
	public String[] solution(String[] record) {
        
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<record.length; i++){
        	String[] arr = record[i].split(" ");
            	if(arr.length==3) map.put(arr[1],arr[2]);
        }
        
        for(int i=0; i<record.length; i++){
        	String[] arr = record[i].split(" ");
            if(arr[0].equals("Enter")){
            	list.add(map.get(arr[1])+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
            }else if(arr[0].equals("Leave")){
            	list.add(map.get(arr[1])+"´ÔÀÌ ³ª°¬½À´Ï´Ù.");
            }
        }
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
        	answer[i] = list.get(i);
        }
        return answer;
    }
	
	
	
	public static void main(String[] args) {
		int price = 3;
		int money = 20;
		int count = 4;
		System.out.println(solution(price, money, count));
	}
}
