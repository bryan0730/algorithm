package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//1679
public class BFSExam3 {

	static int N,K;
	static int[] arr = new int[1000001];
	static int idx;
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int result = bfs(N);
		System.out.println(result);
	}
	
	public static int bfs(int v) {
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		arr[v] = 1;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int i=0; i<3; i++) {
				
				if(temp==K) {
					return arr[temp]-1;
				}
				
				if(i==0) {
					idx = temp+1;
				}else if(i==1) {
					idx = temp-1;
				}else {
					idx = temp*2;
				}
				
				if(idx<0 || idx>=arr.length || arr[idx]!=0) continue;
				
				q.add(idx);
				arr[idx] = arr[temp]+1;;
			}
		}
		
		return -1;
	}
	
}
