import java.util.Scanner;
public class SelectionSortOnPairs {

    public static void selectionSortOnPairs(int nums[][]) {
    	for(int i = 0; i < nums.length - 1; i++) {
	   int minIdx = i;
	   for(int j = i + 1; j < nums.length; j++) {
		if(nums[j][0] < nums[minIdx][0] || (nums[j][0] == nums[minIdx][0] && nums[j][1] < nums[minIdx][1])) {
		    minIdx = j;
		}
	   }
	   int temp[] = nums[i];
	   nums[i] = nums[minIdx];
	   nums[minIdx] = temp;
	}
    }

    public static void print(int nums[][]) {
	for(int i = 0; i < nums.length; i++) {
	   System.out.print("{ " + nums[i][0] + ", " + nums[i][1] + " }, ");
	}
    }
    
    public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int nums[][] = new int[n][2];
	for(int i = 0; i < n; i++) {
	   for(int j = 0; j < 2; j++) {
		nums[i][j] = sc.nextInt();
	   }
	}
	selectionSortOnPairs(nums);
	print(nums);
    }
}
