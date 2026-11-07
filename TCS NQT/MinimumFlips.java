public class MinimumFlips {

    public static int minimumFlips(int start, int goal) {
        // int flips = 0;
        int xor = start ^ goal;
        // while(xor != 0) {
        //     int lsb = xor & 1;
        //     if(lsb == 1)
        //         flips++;
        //     xor = xor >> 1;
        // }

        return Integer.bitCount(xor);
    }

    public static void main(String[] args) {
        System.out.println(minimumFlips(10, 7)); // 3
        System.out.println(minimumFlips(1, 2)); // 2
    }
    
}
