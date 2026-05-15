package Class;
public class CountBinaryStringsWithoutConsecutive1s {

    public static int countBinaryStringsWithoutConsecutive1s(int n) {
        if(n == 0)
            return 1;

        int count = 0;

        for(int i = 0; i < Math.pow(2, n); i++) {
            boolean hasConsecutiveOne = false;
            int currNum = i;
            while(currNum != 0) {
                int lastBit = currNum & 1;
                currNum = currNum >> 1;
                int currentBit = currNum & 1;
                if(lastBit == 1 && currentBit == 1) {
                    hasConsecutiveOne = true;                                                        
                    break;
                }
            }

            if(!hasConsecutiveOne) {
                count++;
            }
        }

        return count;
    }

    /*  Time  - O(2 ^ n)
        Space - O(2 ^ n)
    */
    public static int f1(int n) {
        // base case
        if(n == 0) {
            return 1;
        }

        int count = 0;
        boolean hasConsecutiveOne = false;
        int currNum = n;
        while(currNum != 0) {
            int lastBit = currNum & 1;
            currNum = currNum >> 1;
            int currentBit = currNum & 1;
            if(lastBit == 1 && currentBit == 1) {
                hasConsecutiveOne = true;                                                        
                break;
            }
        }

        if(!hasConsecutiveOne) {
            count++;
        }

        return count + f1(n - 1);
    }

    public static int f(int n) {
        return f1((int)Math.pow(2, n) - 1);
    }

    public static void main(String[] args) {
        // System.out.println(Math.pow(2, 0));
        // System.out.println(countBinaryStringsWithoutConsecutive1s(0)); // 1
        // System.out.println(countBinaryStringsWithoutConsecutive1s(1)); // 2
        // System.out.println(countBinaryStringsWithoutConsecutive1s(2)); // 3                                                                                                                                                                                                                                                    
        // System.out.println(countBinaryStringsWithoutConsecutive1s(3)); // 5                                                                                                                                                                                                                                                    
        // System.out.println(countBinaryStringsWithoutConsecutive1s(4)); // 8                                                                                                                                                                                                                                                    
        System.out.println(f(0)); // 1
        System.out.println(f(1)); // 2
        System.out.println(f(2)); // 3                                                                                                                                                                                                                                                    
        System.out.println(f(3)); // 5                                                                                                                                                                                                                                                    
        System.out.println(f(4)); // 8                                                                                                                                                                                                                                                    
    }
}