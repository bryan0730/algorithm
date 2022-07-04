package programmers.lv2.sol2;

import java.util.Stack;

public class Ex10 {

	//https://programmers.co.kr/learn/courses/30/lessons/12973
	public static int solution(String s) {
		
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			if(stack.isEmpty()) stack.push(s.charAt(i));
			else{
				if(stack.peek()==s.charAt(i)) stack.pop();
				else stack.push(s.charAt(i));
			}
		}

		if(stack.isEmpty()) answer = 1;
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		System.out.println(solution("baabaa"));
	}
}
