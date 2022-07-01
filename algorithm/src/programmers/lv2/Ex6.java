package programmers.lv2;

public class Ex6 {

	//https://programmers.co.kr/learn/courses/30/lessons/12899
	public static String solution(int n) {
		
		String answer = "";
		String[] ar = {"4","1","2"};
		
		while(n>0){
			int idx = n%3;
			n/=3;
			if(idx==0) n--;
			answer = ar[idx]+answer;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		int n = 6;
		System.out.println(solution(n));
	}
	
}
