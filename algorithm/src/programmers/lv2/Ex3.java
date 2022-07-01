package programmers.lv2;

import java.util.Arrays;

public class Ex3 {

	//https://programmers.co.kr/learn/courses/30/lessons/1829
	static boolean[][] visited;
    static int count = 0;
	public static int[] solution(int m, int n, int[][] picture) {

		int numberOfArea = 0;
	    int maxSizeOfOneArea = 0;
		visited = new boolean[m][n];
        int[] answer = new int[2];
        
        for(int i=0; i<m; i++) {
        	
        	for(int j=0; j<n; j++) {
        		if(picture[i][j]!=0 && !visited[i][j]) {
        			numberOfArea++;
        			dfs(picture, i, j, picture[i][j]);
        		}
        		if(count>maxSizeOfOneArea) maxSizeOfOneArea = count;
        		count=0;
        	}
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
	}
	
	public static void dfs(int[][] picture, int x, int y, int num) {
		
		visited[x][y] = true;
		count++;
		int[] xp = {1,0,-1,0};
		int[] yp = {0,-1,0,1};
		
		for(int i=0; i<4; i++) {
			int xx = x+xp[i];
			int yy = y+yp[i];
			
			if(xx<0 || yy<0 || xx>=picture.length || yy>=picture[0].length || visited[xx][yy] || picture[xx][yy]!=num) continue;
			
			dfs(picture, xx, yy, num);
		}	
	}
	
	public static void main(String[] args) {
		
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		System.out.println(Arrays.toString(solution(m, n, picture)));
	}
}
