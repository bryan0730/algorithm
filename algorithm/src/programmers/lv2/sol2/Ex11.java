package programmers.lv2.sol2;

import java.util.Arrays;

public class Ex11 {

	//https://programmers.co.kr/learn/courses/30/lessons/77485
	static int[][] map;
	public static int[] solution(int rows, int columns, int[][] queries) {
		 
		 int[] answer = new int[queries.length];
		 int count = 1;
		 map = new int[rows][columns];
		 
		 for(int i=0; i<rows; i++) {
			 for(int j=0; j<columns; j++) {
				 map[i][j] = count;
				 count++;
			 }
		 }
		 
		 for(int i=0; i<queries.length; i++) {
			 answer[i] = rotate(queries[i]);
		 }
		 
		 return answer;
	}
	 
	 public static int rotate(int[] query) {
		 
		 int next = 0;
		 int before = 0;
		 int min = Integer.MAX_VALUE;
		 
		 int sy = query[0]-1;
		 int sx = query[1]-1;
		 int ey = query[2]-1;
		 int ex = query[3]-1;
		 
		 next = map[sy][ex];
		 for(int i=ex; i>sx; i--) {
			 map[sy][i] = map[sy][i-1];
		 }
		 
		 before = next;
		 next = map[ey][ex];
		 for(int i=ey; i>sy+1; i--) {
			 map[i][ex] = map[i-1][ex];
		 }
		 map[sy+1][ex] = before;
		 
		 before = next;
		 next = map[ey][sx];
		 for(int i=sx; i<ex-1; i++) {
			 map[ey][i] = map[ey][i+1];
		 }
		 map[ey][ex-1] = before;
		 
		 for(int i=sy; i<ey-1; i++) {
			 map[i][sx] = map[i+1][sx];
		 }
		 map[ey-1][sx] = next;
		 
		 for(int i=sy; i<ey+1; i++) {
			 min = Math.min(map[i][sx], min);
			 min = Math.min(map[i][ex], min);
		 }
		 
		 for(int i=sx; i<ex+1; i++) {
			 min = Math.min(map[sy][i], min);
			 min = Math.min(map[ey][i], min);
		 }
		 
		 return min;
	 }
	 
	 public static void main(String[] args) {
		
		 int rows = 6;
		 int columns = 6;
		 int[][] queries= {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		 System.out.println(Arrays.toString(solution(rows, columns, queries)));
	}
}
