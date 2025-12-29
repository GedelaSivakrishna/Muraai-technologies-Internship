package Leetcode_Practice;

public class HIndex2 {

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int ans = 0;
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
           if(n - mid >= citations[mid]) {
                ans = citations[mid];
                lo = mid + 1; 
           } else {
                hi = mid - 1;
           }
        }

        return ans;
    }

    public static void main(String[] args) {
        int citations[] = {0,1,3,5,6};
        int citations2[] = {1,2,100};
        int citations3[] = {0,1,3,5,6,7,8,9,11};

        // ans -> 3
        System.out.println(hIndex(citations));
        // ans -> 2
        System.out.println(hIndex(citations2));
        // ans -> 5
        System.out.println(hIndex(citations3));
    }

}
