package Practice_Sorting;

public class Sorting {

    public static int getMinElementIndex(int nums[], int i) {
        int n = nums.length;
        int minIndex = i;
        for(int j = i + 1; j < n; j++) {
            if(nums[j] < nums[minIndex]) {
                minIndex = j;
            }
        }
        return minIndex;
    }

    /* Time
        1. Average case: O(n^2)
        2. Worst case: O(n^2) 
       Space: O(1)      
    */
    public static void selectionSort(int nums[]) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int minIndex = getMinElementIndex(nums, i);
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    /* Time
        1. Best case: O(n)
        2. Average, Worst case: O(n^2)
       Space: O(1)
       Properties:
        1. Inplace & stable algorithm
        2. Should not consider this algorithm, if heavy data like files need to be sorted as there are n^2 swaps
           done in worst case.
        3. There are n^2 swaps & comparisions involved in this algorithm.
    */
    public static void bubbleSort(int nums[]) {
        int n = nums.length;
        // we need to place n - 1 largest element's in their correct positions
        for(int i = 0; i < n - 1; i++) {
            boolean isSwapped = false;
            for(int j = 0; j < n - i - 1; j++) {
                if(nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                    isSwapped = true;
                }
            }
            // elements are already sorted
            if(!isSwapped) {
                break;
            }
        }
    }

    /* Time
        1. Best case: O(n)
        2. Average, worst case: O(n^2)
       Space: O(1)
       Properties:
        1. It is inplace & stable algorithm.
        2. No swaps involved, we push the element to it's correct position.
        3. In best case, it takes O(n) time.
    */
    public static void insertionSort(int nums[]) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int currElem = nums[i];
            int prevIdx = i - 1;
            // find the correct position for nums[i] in the sorted part
            while(prevIdx >= 0 && nums[prevIdx] > currElem) {
                nums[prevIdx + 1] = nums[prevIdx];
                prevIdx--;
            }
            // place the current element in it's correct position in sorted part
            nums[prevIdx + 1] = currElem;
        }
    }

    public static void f(int nums[], int lo, int hi) {
        if(lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        f(nums, lo, mid); // sort left part
        f(nums, mid + 1, hi); // sort right part
        merge(nums, lo, mid, hi);
    }

    public static void merge(int nums[], int lo, int mid, int hi) {
        int temp[] = new int[hi - lo + 1];
        int i = lo; // track left part
        int j = mid + 1; // track right part
        int k = 0; // track temp array

        while(i <= mid && j <= hi) {
            if(nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // store the remaining elements of 1st half in temp
        while(i <= mid) {
            temp[k++] = nums[i++];
        }

        // store the remaining elements of 2nd half in temp
        while(j <= hi) {
            temp[k++] = nums[j++];
        }

        // copy the temp elements to original array
        k = lo;
        for(int elem : temp)
            nums[k++] = elem;

    }

    /* Time: O(nlogn)
       Space: O(n)
       Properties:
        1. It is a divide & conquer algorithm.
        2. It is a stable and not inplace algorithm.
    */
    public static void mergeSort(int nums[]) {
        f(nums, 0, nums.length - 1);
    }

    public static void q(int nums[], int lo, int hi) {
        if(lo > hi) {
            return;
        }
        int pIndex = partition(nums, lo, hi);
        q(nums, lo, pIndex - 1); // sort to left of partition index
        q(nums, pIndex + 1, hi);  // sort to right of partition index
    }

    public static int partition(int nums[], int lo, int hi) {
        int pivotIndex = randomIndex(lo, hi);
        int pivotElement = nums[pivotIndex];
        // swap pivot & element at index hi
        swap(nums, pivotIndex, hi);
        int m = lo - 1;

        for(int i = lo; i <= hi - 1; i++) {
            if(nums[i] < pivotElement) {
                m++;
                swap(nums, i, m);
            }
        }

        // move to pivot correct position
        m++;
        // place the pivot at it's correct position
        swap(nums, m, hi);
        return m;
    }
     
    /* Time
        1. Best, average case: O(nlogn)
        2. Worst case: O(n^2)
       Space - The space taken by call stack
        1. Best, average case: O(logn)
        2. Worst case: O(n)
       Properties
        1. It is an inplace & unstable algorithm.
    */
    public static void quickSort(int nums[]) {
        q(nums, 0, nums.length - 1);
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int randomIndex(int lo, int hi) {
        return (int)(Math.random() * (hi - lo + 1) + lo);
    }

    public static void print(int nums[]) {
        for(int elem : nums) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {-1, -4, 3, 5, 2, 9, 6, -10};
        // selectionSort(nums);
        // bubbleSort(nums);
        // insertionSort(nums);
        // mergeSort(nums);
        quickSort(nums);
        print(nums);
    }
}
