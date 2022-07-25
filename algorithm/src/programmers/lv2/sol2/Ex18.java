package programmers.lv2.sol2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ex18 {

	//https://school.programmers.co.kr/learn/courses/30/lessons/86052
	static int N,M;
	static boolean[][][] visited;
	static String[] map;
	public static int[] solution(String[] grid) {
		
		List<Integer> list = new ArrayList<>();
        
        map = grid;
        N = grid.length;
        M = grid[0].length();
        visited = new boolean[N][M][4];
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		for(int d=0; d<4; d++) {
        			if(!visited[i][j][d]) {
        				list.add(bfs(i, j, d));
        			}
        		}
        	}
        }
        
        
        return list.stream().sorted().mapToInt(i -> i).toArray();
    }
	
	public static int bfs(int x, int y, int d) {
		
		Queue<int[]> q = new LinkedList<>();
		visited[x][y][d] = true;
		q.add(new int[] {x,y,d});
		
		int count = 0;
		
		int[] xLoc = {1,0,-1,0};
		int[] yLoc = {0,1,0,-1};
		
		while(!q.isEmpty()) {
			count++;
			
			int[] ar = q.poll();
			int xx = ar[0];
			int yy = ar[1];
			int dd = ar[2];
			
			if(map[xx].charAt(yy)=='L') {
				dd = dd==0? 3 : dd-1;
			}else if(map[xx].charAt(yy)=='R') {
				dd = dd==3? 0 : dd+1;
			}
			
			xx = (xx+xLoc[dd]+N)%N;
			yy = (yy+yLoc[dd]+M)%M;
			
			if(xx<0 || yy<0 || xx>=N || yy>=M || visited[xx][yy][dd]) continue;
			
			q.add(new int[] {xx,yy,dd});
			visited[xx][yy][dd] = true;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		/*
		 * À§ 0 / ¿À 1 / ¾Æ 2 / ¿Þ 3
		 * 
		 * L
		 * 0->3
		 * 1->0
		 * 2->1
		 * 3->2
		 * d = d==0? 3 : d-1;
		 * 
		 * R
		 * 0->1
		 * 1->2
		 * 2->3
		 * 3->0
		 * d = d==3? 0 : d+1;
		 * 
		 * 
		 */
		String[] grid = {"SL","LR"};
		System.out.println(Arrays.toString(solution(grid)));
	}
}
