import java.util.Scanner;
public class MaxSubsetSum {
	
	static int maxSubsetSum = Integer.MIN_VALUE;
	public static void f(int arr[], int i, int limit, int sum) {
		maxSubsetSum = Math.max(sum, maxSubsetSum);
		
        if(i == arr.length) return;

		// include element in subset, if adding current element to sum <= limit
		if(sum + arr[i] <= limit) {
			f(arr, i + 1, limit, sum + arr[i]);
		}

		// exclude element in subset
		f(arr, i + 1, limit, sum);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		// array i/p
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int limit = sc.nextInt();
		maxSubsetSum = 0;
		f(arr, 0, limit, 0);
		System.out.println("MaxSubset sum = " + maxSubsetSum);
	}
}