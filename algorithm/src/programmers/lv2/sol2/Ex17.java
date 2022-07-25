package programmers.lv2.sol2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex17 {

	//https://school.programmers.co.kr/learn/courses/30/lessons/64065
	public static int[] solution(String s) {
		
        
        String st = s.substring(2, s.length()-2);
        st = st.replace("},{", "-");
        String[] ar = st.split("-");
        
        
        Arrays.sort(ar, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
        
        List<String> list = new ArrayList<>();
        
        
        for(int i=0; i<ar.length; i++) {
        	String[] arr = ar[i].split(",");
        	for(int j=0; j<arr.length; j++) {
        		if(!list.contains(arr[j])) list.add(arr[j]);
        	}
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = Integer.parseInt(list.get(i));
        }
        
        return answer;
    }
	
	//lv1 greedy Ã¼À°º¹
	public int solution(int n, int[] lost, int[] reserve) {
		
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = 0;
        boolean[] visited = new boolean[reserve.length];
        int pos = n-lost.length;
        
        for(int i=0; i<lost.length; i++){
            int los = lost[i];
            for(int j=0; j<reserve.length; j++){
               if(visited[j]) continue;
	                if(reserve[j]-1 == los || reserve[j]+1 == los){
	                	visited[i] = true;
			            answer++;
			            break;
	                }
            	}
			}
        
        return answer+pos;
    }
	
	public static int solution2(int n, int[] lost, int[] reserve) {
		
		
		
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		List<String> list = new ArrayList<>();
		for(int i=0; i<lost.length; i++) list.add(Integer.toString(lost[i]));
		
		for(int a : reserve) {
				
				if(list.remove(Integer.toString(a))) continue;
				if(list.remove(Integer.toString(a+1)) || list.remove(Integer.toString(a-1))) continue;
				
		}
		
		return n-list.size();
	}
	
	public static void main(String[] args) {
		
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//		String st = s.substring(2, s.length()-2);
//        String a = st.replace("},{", "-");
//        String[] ar = a.split("-");
//        System.out.println(st);
//        System.out.println(a);
//        Arrays.sort(ar, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.length()-o2.length();
//			}
//		});
//        
//        System.out.println(Arrays.toString(ar));
		System.out.println(Arrays.toString(solution(s)));	
		
	}
}
