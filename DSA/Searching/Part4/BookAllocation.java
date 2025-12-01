public class BookAllocation {

    // Time O(n * (totalPages - maxPage))
    public static int naiveApproach(int pages[], int k) {
        // If no enough books for k students to allocate
        if(k > pages.length) {
            return -1;
        }

        int totalPages = 0, max = 0;
        for(int elem : pages) {
            totalPages += elem;
            max = Math.max(elem, max);
        }

        int lo = max, hi = totalPages;
        // check for each possible minimum maxPage and return the first possible maxPage
        for(int i = lo; i <= hi; i++) {
            if(canAllocate(pages, pages.length, k, i)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean canAllocate(int pages[], int N, int M, int mid) {
        int count = 1;
        int pageCount = 0;
        for(int i = 0; i < N; i++) {
            if(pageCount + pages[i] > mid) {
                count++;
                pageCount = pages[i];
            } else {
                pageCount += pages[i];
            }
            if(count > M) {
                return false;
            }
        }
        return count <= M;
    }

    // Time O(n log((totalPages - mMinus1Pages) - firstPage))
    //Space O(1)
    public static int bookAllocation(int N, int pages[], int M) {
        int totalPages = 0;
        int max = 0;
        for(int i = 0; i < N; i++) {
            totalPages += pages[i];
            max = Math.max(max, pages[i]);
        }
        int lo = max, hi = totalPages;
        int ans = -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(canAllocate(pages, N, M, mid)) {
                // found potential answer
                ans = mid;
                hi = mid - 1;
            } else {
                // discard left
                lo = mid + 1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int N = 4;
        int pages[] = {12, 34, 67, 90};
        int M = 2;
        // ans 113
        // System.out.println(bookAllocation(N, pages, M));
        int N2 = 3;
        int pages2[] = {15, 17, 20};
        int M2 = 5;
        // ans -1
        // System.out.println(bookAllocation(N2, pages2, M2));
        // ans -1
        // System.out.println(naiveApproach(pages2, M2));
        // ans 113
        System.out.println(naiveApproach(pages, M));
    }
}
