package Class;

public class HouseRobber2 {

    public static int f(int houses[]) {
        int n = houses.length;
        if (n == 1) return houses[0];

        int next2 = houses[n - 1];
        int next1 = Math.max(houses[n - 2], houses[n - 1]);

        for(int i = n - 3; i >= 0; i--) {
            int curr = Math.max(houses[i] + next2, next1);
            next2 = next1;
            next1 = curr;
        }

        next1 = n % 2 == 0 ? next1 : next1 - Math.min(houses[0], houses[n - 1]);
        return Math.max(next1, next2);
    }

    public static void main(String[] args) {
        int nums[] = {2,3,2};
        int nums2[] = {1,2,3,1};
        System.out.println(f(nums)); // 3
        System.out.println(f(nums2)); // 4
    }
}