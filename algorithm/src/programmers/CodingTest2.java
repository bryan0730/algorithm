package programmers;

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
}
