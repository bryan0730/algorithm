package programmers.lv2.sol1;

public class Ex1 {

	//https://programmers.co.kr/learn/courses/30/lessons/60057
	public static int solution(String s) {
		
		int answer = s.length();
		
		for(int i=1; i<=s.length()/2; i++) {
			String init = s.substring(0,i);
			StringBuilder sb = new StringBuilder();
			int count = 1;
			
			for(int j=i; j<=s.length(); j+=i) {
				int end=0;
				if(j+i>s.length()) end = s.length();
				else end = j+i;
				
				String next = s.substring(j,end);
				
				if(init.equals(next)) {
					count++;
				}else {
					if(count==1) sb.append(init);
					else {
						sb.append(count+init);
					}
					init = next;
					count = 1;
				}
			}
			sb.append(init); //마지막 문자열 추가
			answer = Math.min(answer, sb.toString().length());
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		String s= "aabbaccc";
		System.out.println(solution(s));
	}
}
