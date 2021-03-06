package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSExam {

	public static int[][] graph = {{},
			{2,3,8},
			{1,7},
			{1,4,5},
			{3,5},
			{3,4},
			{7},
			{2,6,8},
			{1,7}};
	public static boolean[] visite = new boolean[9];
	
	//1 2 3 8 7 4 5 6 
	public static void bfs(int v) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			if(visite[node]) continue;
			
			visite[node] = true;
			System.out.print(node + " ");
			
			for(int i=0; i<graph[node].length; i++) {
				int idx = graph[node][i];
				if(!visite[idx]) {
					q.add(idx);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		bfs(1);
	}
	
}
