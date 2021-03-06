package algorithm;

public class Step1 {

	/*
	 * 정렬 알고리즘
	 */
	
	/*
	 * 선택정렬
	 * 
	 * <시간복잡도>
	 * 10+9+8+7+...+1 등차수열
	 * -> 10*(10+1)/2
	 * -> N*(N+1)/2
	 * -> N*N
	 * -> O(N*N) 빅오표현식
	 */
	public void sort1(int[] arr) {
		
		//int[] answer = new int[arr.length];
		int min;
		int temp;
		
		for(int i=0; i<arr.length-1; i++) {
			min = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
}
