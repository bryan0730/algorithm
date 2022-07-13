package programmers.lv2.sol2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Ex15 {

	//https://school.programmers.co.kr/learn/courses/30/lessons/81302
	public static int[] solution(String[][] places) {
        int[] result = new int[places.length];
        for(int i = 0; i < places.length; i++){
            result[i] = isCorrext(places[i]);
        }
        return result;
    }
    
    public static int isCorrext(String[] board) {
    	
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                if(board[i].charAt(j) == 'P') { 
                    if(!bfs(board, i, j)) return 0; 
                }
            }
        }
        return 1;
    }
	
	public static boolean bfs(String[] ar, int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[5][5];
		q.offer(new int[] {x,y});
		
		int[] moveX = {1,0,-1,0};
		int[] moveY = {0,1,0,-1};
		
		while(!q.isEmpty()) {
			
			int[] loc = q.poll();
			int xx = loc[0];
			int yy = loc[1];
			
			
			for(int i=0; i<4; i++) {
				int xxx = xx+moveX[i];
				int yyy = yy+moveY[i];
				int manhattan = Math.abs(xxx-x) + Math.abs(yyy-y);
				
				if(xxx<0 || yyy<0 || xxx>=5 || yyy>=5 || (xxx==x && yyy==y)) continue;
				if(visited[xxx][yyy] || manhattan > 2) continue;
				
				visited[xxx][yyy] = true;
				if(ar[xxx].charAt(yyy) == 'X') continue;
				else if(ar[xxx].charAt(yyy) == 'P' && manhattan<=2) return false;
				else if(ar[xxx].charAt(yyy) == 'O' && manhattan==1) q.offer(new int[] {xxx,yyy});
			}
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		String[][] places = {
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
		};
		
		System.out.println(Arrays.toString(solution(places)));
	}
}
