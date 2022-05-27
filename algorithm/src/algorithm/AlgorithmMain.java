package algorithm;

public class AlgorithmMain {

	public static void main(String[] args) {
		Step1 st = new Step1();
		
		int[] arr = {7, 3, 8, 10, 4, 2, 1, 6, 5, 9};
		
		st.sort1(arr);
		
		for(int a : arr) {
			System.out.println(a);
		}
		
		Step2 st2 = new Step2();
		int[] a = st2.BubbleSort(arr);
		
		for(int b : a) {
			System.out.println(b);
		}
		
	}
}
