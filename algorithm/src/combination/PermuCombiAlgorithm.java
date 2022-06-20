package combination;

public class PermuCombiAlgorithm {

	/*
	 * ����
	 * ���� �ٸ� n������ r���� �̾� �����ϴ� ����� ��
	 * (���� ��� o)
	 */
	public static void permutation(int[] arr, int[] out, boolean[] visited, int r, int depth) {
		
		if(depth == r) {
			for(int a : out) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				out[depth] = arr[i];
				permutation(arr, out, visited, r, depth+1);
				visited[i] = false;
			}
		}
	}
	
	/*
	 * ���� - ��Ʈ��ŷ
	 * ���� �ٸ� n������ ���� ���� r���� �̴� ����� ��
	 * (���� ��� x)
	 */
	public static void combination(int[] arr, boolean[] visited, int depth, int start, int r) {
		
		if(depth == r) {
			for(int i=0; i<arr.length; i++){
                if(visited[i]) System.out.print(arr[i] + " ");
            }
			System.out.println();
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(arr, visited, depth+1, i+1, r);
				visited[i] = false;
			}
		}
	}
	
	/*
	 * ���� - ���
	 */
	public static void combination2(int[] arr, boolean[] visited, int depth, int r) {
		
		if(r==0) {
			for(int i=0; i<arr.length; i++) {
				if(visited[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		if(depth == arr.length) return;
		
		visited[depth] = true;
		combination2(arr, visited, depth+1, r-1);
		visited[depth] = false;
		combination2(arr, visited, depth+1, r);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4};
		int r = 3;
		permutation(arr, new int[r], new boolean[arr.length], r, 0);
		combination(arr, new boolean[arr.length], 0, 0, r);
		combination2(arr, new boolean[arr.length], 0, r);
	}
}
