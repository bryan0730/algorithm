package dfs;

import java.util.Stack;

public class DFSExam {

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
	
	
	//dfs ��� 1 2 7 6 8 3 4 5 
	public static void dfsRecursive(int v) {
		
		visite[v] = true;
		
		System.out.print(v + " ");
		
		for(int i : graph[v]) {
			if(!visite[i]) {
				dfsRecursive(i);
			}
		}
	}
	
	//dfs ����
	public static void dfsStack(int v) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(v);
		//visite[v] = true;
		
		while(!stack.isEmpty()) {
			int idx = stack.pop();
			
			if(visite[idx]) continue;
			
			visite[idx] = true;
			System.out.print(idx + " ");
			
			for(int i=graph[idx].length-1; i>=0; i--) {
				int node = graph[idx][i];
				
				if(!visite[node]) {
					stack.push(node);
					//visite[node] = true;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
//		dfsRecursive(1);
//		System.out.println("");
		dfsStack(1);
	}
}
