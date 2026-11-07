
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class MinimumCostForTickets {

    static int lastDay;
    static int c[];
    static Set<Integer> set;
    static int dp[];

    // Time - O(D)  Space - O(D)
    // Here D is the last day in the travel days
    public static int f(int day) {
        if (day > lastDay) return 0;

        if (!set.contains(day)) return dp[day] =  f(day + 1);

        if (dp[day] != -1) return dp[day];

        int ans;
        ans = Math.min(c[0] + f(day + 1), Math.min(c[1] + f(day + 7), c[2] + f(day + 30)));
        return dp[day] = ans;
    }
    
    public static void main(String[] args) {
        int days[] = {1,4,6,7,8,20};
        int costs[] = {2, 7, 15};
        lastDay = days[days.length - 1];
        c = costs;
        set = new HashSet<>();
        dp = new int[400];
        Arrays.fill(dp, -1);
        for(int elem : days)
            set.add(elem);
        System.out.println(f(1)); // 11
    }
}
