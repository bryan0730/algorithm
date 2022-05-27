package dfs;

import java.util.Scanner;

public class DFSExam3 {

	public static int[][] arr;
	public static boolean[] visited;
	private static Scanner sc;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		arr = new int[n+1][n+1];
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		visited = new boolean[n+1];
		
		dfs(v);
	}
	
	public static void dfs(int v) {
		visited[v] = true;
		System.out.println(v + " ");
		
		if(v == arr.length) {
			return;
		}
		
		for(int a=1; a<arr.length; a++) {
			if(arr[v][a]==1 && !visited[v]) {
				dfs(a);
			}
		}
	}
}
