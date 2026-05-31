package Backtracking;

public class ChangeArray {

    public static void f(int arr[], int i, int val) {
        // base case
        if(i == arr.length) {
            print(arr);
            return;
        }

        arr[i] = val;
        f(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    public static void print(int nums[]) {
        for(int elem : nums) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int arr[] = new int[5];
        f(arr, 0, 1);
        print(arr);
    }
}
