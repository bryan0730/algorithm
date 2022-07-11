package programmers.lv2.sol2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex14 {

	//https://school.programmers.co.kr/learn/courses/30/lessons/17677
	public static int solution(String str1, String str2) {
		
		List<String> strList1 = new ArrayList<>();
		List<String> strList2 = new ArrayList<>();
		List<String> gyoZip = new ArrayList<>();
		List<String> hapZip = new ArrayList<>();
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		for(int i=0; i<str1.length()-1; i++) {
			char fir = str1.charAt(i);
			char sec = str1.charAt(i+1);
			
			if(fir>='a' && fir<='z' && sec>='a' && sec<='z') {
				strList1.add(fir+""+sec);
			}
		}
		
		for(int i=0; i<str2.length()-1; i++) {
			char fir = str2.charAt(i);
			char sec = str2.charAt(i+1);
			
			if(fir>='a' && fir<='z' && sec>='a' && sec<='z') {
				strList2.add(fir+""+sec);
			}
		}
		
		Collections.sort(strList1);
		Collections.sort(strList2);
		
		for(String a : strList1) {
			if(strList2.contains(a)) {
				gyoZip.add(a);
				strList2.remove(a);
			}
			hapZip.add(a);
		}
		
		for(String a : strList2) {
			hapZip.add(a);
		}
		
		double jakard = 0;
		if(hapZip.size()==0) {
			jakard = 1;
		}else {
			jakard = (double)gyoZip.size()/(double)hapZip.size();
		}

		return (int)(jakard * 65536);
	}
	
	public static void main(String[] args) {

		String str1 = "FRANCE";
		String str2 = "french";
		System.out.println(solution(str1, str2));
	}
	
}
