package programmers.lv2.sol2;

public class Ex13 {
	
	//https://school.programmers.co.kr/learn/courses/30/lessons/60058
	public static String solution(String p) {
		
		if(p.length()==0) return "";
		
		int lcount = 0;
		int rcount = 0;
		String u = "";
		String v = "";
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i)=='(') lcount++;
			else rcount++;
			
			if(lcount==rcount && lcount!=0 && rcount!=0) {
				u = p.substring(0, i+1);
				if(i != p.length()-1) {
					v = p.substring(i+1, p.length());
				}
				break;
			}
		}
		
		if(isRightBracket(u)) return u+solution(v);
		else {
//			String uu = "";
			String s = "("+solution(v);
			s += ")";
			
			u = u.substring(1, u.length()-1);
			
//			for(int i=u.length()-1; i>=0; i--) {
//				uu += u.charAt(i);
//			}
			u = u.replace("(", ".");
			u = u.replace(")", "(");
			u = u.replace(".", ")");
			return s+=u;
		}
	}
	
//	public static boolean isRightBracket(String str) {
//		
//        int open = 0;            
//        if(str.charAt(0) ==')') return false;
//        for(int i =0;i<str.length();i++){
//            if(str.charAt(i) == '(') open++;
//            else {
//                open--;
//                if(open<0) return false;
//            }
//        }
//        return true;
//	}
	
	public static boolean isRightBracket(String u) {

		if(u.charAt(0)==')') return false;
		return true;
	}
	
	public static void main(String[] args) {
		
		String p = "()))((()";
		System.out.println(solution(p));
	}
}
