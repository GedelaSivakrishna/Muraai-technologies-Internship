import java.util.HashSet;
import java.util.Scanner;
public class DigitalLockerSystem {

    public static void digitalLockerSystem(int pin) {
        int even = 0, sum = 0;
        HashSet<Integer> set = new HashSet<>();
        while(pin != 0) {
            int digit = pin % 10;
            sum += digit;
            if(digit % 2 == 0) even++;
            set.add(digit);
            pin /= 10;
        }

        if(even == 2 && sum % 3 == 0 && set.size() == 4)
            System.out.println("OPEN");
        else
            System.out.println("LOCKED");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pin = sc.nextInt();
        digitalLockerSystem(pin);
    }
}
