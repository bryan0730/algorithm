package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1012
public class DFSExam5 {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,M,K;
	static int[][] graph;
	static boolean[][] visited;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i=0; i<K; i++) {
			String input = br.readLine();
			String[] inputs = input.split(" ");
			int m1 = Integer.parseInt(inputs[0]);
			int n1 = Integer.parseInt(inputs[1]);
			
			graph[m1][n1] = 1;
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(graph[i][j]!=0 && !visited[i][j]) {
					dfs(i, j);
					count += 1;
				}
				
			}
		}
		System.out.println(count);
	}
	
	public static void dfs(int x, int y) {
		
		visited[x][y] = true;
		int[] xArr = {0, 1, 0, -1};
		int[] yArr = {1, 0, -1, 0};
		
		for(int i=0; i<4; i++) {
			int xx = x+xArr[i];
			int yy = y+yArr[i];
			
			if(xx<0 || xx>=M || yy<0 || yy>=N) continue;
			if(graph[xx][yy]==0 || visited[xx][yy]) continue;
			
			dfs(xx, yy);
		}
	}
}
