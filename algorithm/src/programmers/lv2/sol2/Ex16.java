package programmers.lv2.sol2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex16 {

	static List<Character> opList = new ArrayList<>();
	static Set<Character> set = new HashSet<>();
	static List<Long> numList = new ArrayList<>();
	static long answer = 0;
	
	public static long solution(String expression) {
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<expression.length(); i++) {
			char ch = expression.charAt(i);
			if(ch=='+' || ch=='-' || ch=='*') {
				opList.add(ch);
				set.add(ch);
				numList.add(Long.parseLong(sb.toString()));
				sb = new StringBuilder();
			}else {
				sb.append(ch);
			}
		}
		numList.add(Long.parseLong(sb.toString()));
		
		char[] ar = new char[set.size()];
		int idx = 0;
		for(char a : set) {
			ar[idx] = a;
			idx++;
		}
		
		permutation(ar, 0, new char[ar.length], new boolean[ar.length]);
		
        return answer;
    }
	
	public static void permutation(char[] ar, int depth, char[] out, boolean[] visited) {
		
		if(depth==ar.length) {
			answer = Math.max(answer, calculator(out));
			return;
		}
		
		for(int i=0; i<ar.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				out[depth] = ar[i];
				permutation(ar, depth+1, out, visited);
				visited[i] = false;
			}
		}
	}
	
	public static long calculator(char[] out) {
		
		long result = 0;
		List<Character> operList = new ArrayList<>(opList);
		List<Long> numberList = new ArrayList<>(numList);
		for(char op : out) {
			
			while(operList.contains(op)) {
				int idx = operList.indexOf(op);
				long formula = 0;
				switch (op) {
				case '+':
					formula = numberList.get(idx) + numberList.get(idx+1);
					numberList.remove(idx);
					numberList.remove(idx);
					operList.remove(idx);
					numberList.add(idx, formula);
					break;
				
				case '-':
					formula = numberList.get(idx) - numberList.get(idx+1);
					numberList.remove(idx);
					numberList.remove(idx);
					operList.remove(idx);
					numberList.add(idx, formula);
					break;
				
				case '*':
					formula = numberList.get(idx) * numberList.get(idx+1);
					numberList.remove(idx);
					numberList.remove(idx);
					operList.remove(idx);
					numberList.add(idx, formula);
					break;
				}
			}
		}
		
		result = Math.abs(numberList.get(0));
		
		return result;
	}
	
	public static void main(String[] args) {
		
		String expression = "100-200*300-500+20";
		System.out.println(solution(expression));
	}
}
