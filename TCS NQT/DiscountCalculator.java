import java.util.Scanner;
public class DiscountCalculator {

  public static void discountedValue(int amount) {
    double result;
    if(amount < 1000) {
	result = amount * 0.95;
    } else if(amount < 5000) {
	result = amount * 0.9;
    } else {
	result = amount * 0.85;
    }
    System.out.printf("%.3f", result);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
	int amount = sc.nextInt();
        discountedValue(amount);
    }
 }
}