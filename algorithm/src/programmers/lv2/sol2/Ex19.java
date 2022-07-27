package programmers.lv2.sol2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Ex19 {

	//https://school.programmers.co.kr/learn/courses/30/lessons/42577
	public static boolean solution(String[] phone_book) {
		
		Arrays.sort(phone_book, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
		
		for(int j=0; j<phone_book.length; j++) {
			String target = phone_book[j];
			for(int i=j; i<phone_book.length-1; i++) {
				String s = phone_book[i+1].substring(0, target.length());
				if(target.equals(s)) return false;
			}
		}
		
		
		return true;
	}
	
	public static boolean solution2(String[] phone_book) {
        boolean answer = true;
        HashMap<String, String> map = new HashMap<>();
        
        for(String book : phone_book){
            map.put(book, book);
        }
        
        for(String book : phone_book){
            for(int i=1; i<book.length(); i++){
                if(map.containsKey(book.substring(0, i))){
                    answer = false;
                    break;
                }
            }
        }   
        return answer;
    }
	
	public static void main(String[] args) {
		
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution2(phone_book));
	}
	
}
