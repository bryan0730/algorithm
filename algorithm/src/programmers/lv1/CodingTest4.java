package programmers.lv1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingTest4 {

	//https://programmers.co.kr/learn/courses/30/lessons/12921
	public int solution(int n) {
		
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
        	if(isCheck(i)) answer++;
        }
        
        return answer;
    }
	
	public boolean isCheck(int n) {
		
		for(int i=2; i*i<=n; i++) {
        	if(n%i==0) return false;
        }
		if(n<=1) return false;
		return true;
	}
	
	//https://programmers.co.kr/learn/courses/30/lessons/12930
	public String solution(String s) {
		
		String answer = "";
		int count = 0;
		String[] ar = s.split("");
		for(int i=0; i<ar.length; i++) {
			count = ar[i].contains(" ")?0:count+1;
			answer += count%2==0 ? ar[i].toLowerCase():ar[i].toUpperCase();
		}
		
		return answer;
	}
	
	//https://programmers.co.kr/learn/courses/30/lessons/12932
	public int[] solution(long n) {
		
		long num = n;
		int cnt = 0;
		while(num!=0) {
			num/=10;
			cnt++;
		}
		int[] answer = new int[cnt];
		for(int i=0; num!=0; i++) {
			answer[i] = (int) (num%10);
			num/=10;
		}
		
		return answer;
	}
	
	public long solution2(long n) {
		
		long answer = 0;
		
		String a = String.valueOf(n);
		char[] ar = a.toCharArray();
		Arrays.sort(ar);
		StringBuilder sb = new StringBuilder(new String(ar));
		String b = sb.reverse().toString();
		
		answer = Long.parseLong(b);
		
		return answer;
	}
	
	//https://programmers.co.kr/learn/courses/30/lessons/12935
	public int[] solution(int[] arr) {
		
		 if(arr.length==1){
	            int[] ar = {-1};
	            return ar;
	        }
	        int cnt = 0;
	        int[] temp = Arrays.copyOfRange(arr, 0, arr.length);
	        int[] answer = new int[arr.length-1];
	        Arrays.sort(temp);
	        int min = temp[0];
	        for(int i=0; i<arr.length; i++){
	            if(arr[i]!=min){
	                answer[cnt] = arr[i];
	                cnt++;
	            }  
	        }
	        
	        return answer;
	}
	
	//https://programmers.co.kr/learn/courses/30/lessons/12940
	public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int big = Math.max(n, m);
        int small = Math.min(n, m);
        
        answer[0] = gcd(big, small);
        answer[1] = big*small/answer[0];
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }
    
    //네이버 웹툰 코테 2번 문제
    public static String[] solution2(String s) {
    	
    	String s1 = s.substring(0, s.length()/2);
    	String s2 = s.substring(s.length()/2, s.length());
    	
    	List<String> list = new ArrayList<>();
    	
    	String a = "";
    	String b = "";
    	int start=0;
    	int size = s1.length();
    	for(int i=0; i<size; i++) {
    		
    		a = s1.substring(0, start+1);
    		b = s2.substring(s2.length()-start-1, s2.length());

    		if(a.equals(b)) {
    			list.add(a);
    			s1 = s1.substring(start+1, s1.length());
    			s2 = s2.substring(0, s2.length()-start-1);
    			start=0;
    			continue;

    		}
    		start++;
    	}
    	
    	String[] answer = new String[list.size()*2];
    	for(int i=0; i<list.size(); i++) {
    		answer[i] = list.get(i);
    	}
    	int idx = list.size();
    	for(int i=list.size()-1; i>=0; i--) {
    		answer[idx] = list.get(i);
    		idx++;
    	}
    	
    	return answer;
    }
    
	public static void main(String[] args) {
		
		String s = "abcxyasdfasdfxyabc";

		System.out.println(Arrays.toString(solution2(s)));

	}
}
