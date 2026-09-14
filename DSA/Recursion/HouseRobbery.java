public class HouseRobbery {

    public static int f(int arr[], int idx) {
        // base case
        if(idx >= arr.length) return 0;

        return Math.max( arr[idx] + f(arr, idx + 2), 0 + f(arr, idx + 1) );
    }
    
    public static void main(String[] args) {
        
    }
}
