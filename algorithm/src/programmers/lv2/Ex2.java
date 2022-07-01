package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Ex2 {
	
	//https://programmers.co.kr/learn/courses/30/lessons/42888
	public static String[] solution(String[] record) {
		
		Map<String, String> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<record.length; i++) {
			String[] info = record[i].split(" ");
			if(info.length==3) {
				map.put(info[1], info[2]);
			}
		}
		for(Entry<String, String> a:map.entrySet()) System.out.println(a.getKey()+" : "+a.getValue());
		
		for(int i=0; i<record.length; i++) {
			String[] arr = record[i].split(" ");
			if(arr[0].equals("Enter")) {
				list.add(map.get(arr[1])+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
			}else if(arr[0].equals("Leave")) {
				list.add(map.get(arr[1])+"´ÔÀÌ ³ª°¬½À´Ï´Ù.");
			}
		}
		
		String[] answer = new String[list.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(Arrays.toString(solution(record)));
	}
}
