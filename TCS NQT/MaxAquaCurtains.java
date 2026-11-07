import java.util.Scanner;
public class MaxAquaCurtains {

    public static int maxAqua(String substr) {
        int count = 0;
        for(char ch : substr.toCharArray()) {
            if(ch == 'a') count++;
        }
        return count;
    }

    public static int maxAquaCurtains(String curtains, int L) {
        int N = curtains.length();
        int result = 0;
        int idx = 0;
        for(idx = 0; idx + L < N; idx += L) {
            String currSubStr = curtains.substring(idx, idx + L);
            result = Math.max(result, maxAqua(currSubStr));
        }
        result = Math.max(result, maxAqua(curtains.substring(idx)));

        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int L = sc.nextInt();
        System.out.println(maxAquaCurtains(str, L));
    }
}