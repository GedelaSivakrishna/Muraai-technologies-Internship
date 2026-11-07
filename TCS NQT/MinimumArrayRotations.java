import java.util.Scanner;
public class MinimumArrayRotations {
	public static int minimumRotations(int arr1[], int arr2[]) {
		int n = arr1.length;
		int left = arr1[n - 1]; // left of 0th element in arr1
		int right = arr1[1]; // right of 0th element in arr1
		int index = -1;

		for(int i = 0; i < n; i++) {
			if(arr2[i] == arr1[0]) {
				if(i - 1 >= 0 && i + 1 < n) {
					if(arr2[i - 1] == left && arr2[i + 1] == right) {
						index = i;
						break;
                    }
                } else if(i == 0) {
                    if(arr2[n - 1] == left && arr2[1] == right) {
                        index = 0;
                        break;
                    }
                } else {
                    if(arr2[i - 1] == left && arr2[0] == right) {
                        index = n - 1;
                        break;
                    }
                }
			}
		}
		return Math.min(index, n - index);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr1[] = new int[n];
		int arr2[] = new int[n];
		// 1st array i/p
		for(int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}

		// 2nd array i/p
		for(int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}

		System.out.println(minimumRotations(arr1, arr2));
	}
}