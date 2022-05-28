package dfs;

import java.util.Scanner;
import java.util.Stack;

public class DFSExam2 {

	static final int MAX_N=10;
	static int N,E;
	static int[][] Graph = new int[MAX_N][MAX_N];
	static boolean[] Visited = new boolean[MAX_N];
	
	static void dfs(int node) {
		Visited[node] = true;
		System.out.print(node + " ");
		
		for(int next=0; next<N; ++next) {
			if(!Visited[next] && Graph[node][next]!=0) {
				dfs(next);
			}
		}
		//0 1 3 4 2
	}
	
	static void dfsStack(int node) {
		boolean[] visited = new boolean[MAX_N];
		Stack<Integer> stack = new Stack<>();
		
		stack.push(node);
		
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			if(visited[curr]) continue;
			
			visited[curr] = true;
			System.out.print(curr + " ");
			
			for(int next=0; next<N; ++next) {
				if(!visited[next] && Graph[curr][next]!=0){
					stack.push(next);
				}
			}
		}
		//0 2 4 3 1
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		E = sc.nextInt();
		
		for(int i=0; i < E; ++i) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			Graph[u][v] = Graph[v][u] = 1;
		}
		
		dfs(0);
	}
	
}
