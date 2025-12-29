package Leetcode_Practice;

public class SearchInSortedRotatedArrayII {

    public static boolean searchInSortedRotatedArrayII(int arr[], int key) {
         // code here
        int n = arr.length;
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] == key) {
                return true;
            }
            // check if lo, mid & hi are equal
            if(arr[lo] == arr[mid] && arr[mid] == arr[hi]) {
                lo++;
                hi--;
                continue;
            }
            
            // upper curve
            if(arr[lo] <= arr[mid]) {
                // check if element lies in sorted part
                if(arr[lo] <= key && key <= arr[mid]) { 
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else { // lower curve
                // check if element lies in sorted part
                if(arr[mid] <= key && key <= arr[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        
    }
}
