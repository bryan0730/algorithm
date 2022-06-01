package programmers;

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
}
