import java.util.Scanner;
public class TrafficPollution {

    public static int calculateTrafficFineAmount(int digits[], int date, int x) {
        int odd = 0;
        int n = digits.length;
        for(int elem : digits) {
            if(elem % 2 != 0) odd++;
        }
        
        return date % 2 == 0 ? odd * x : (n - odd) * x;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int digits[] = new int[n];
        for(int i = 0; i < n; i++)
            digits[i] = sc.nextInt();
        int date = sc.nextInt();
        int x = sc.nextInt();
        System.out.println(calculateTrafficFineAmount(digits, date, x));
    }
}
