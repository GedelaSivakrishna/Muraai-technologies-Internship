public class ToggleBulbs {

    public static int toggleBulbs(int n) {
        // if(n == 1) return 1;
        // int bulbs[] = new int[n];

        // for(int i = 2; i < n; i++) {
        //     for(int j = i; j <= n; j += i) {
        //         // toggle every ith bulb
        //         bulbs[j - 1] = bulbs[j - 1] == 0 ? 1 : 0;
        //     }
        // }
        // bulbs[n - 1] = bulbs[n - 1] == 0 ? 1 : 0;

        // // count the total bulbs which are on (zeros)
        // int count = 0;
        // for(int bulb : bulbs) {
        //     if(bulb == 0) count++;
        // }

        // return count;

        return (int)Math.sqrt(n);
    }
    
    public static void main(String[] args) {
        // System.out.println(toggleBulbs(6)); // 2
        // System.out.println(toggleBulbs(3)); // 1
        System.out.println(toggleBulbs(20)); // 4
    }
}
