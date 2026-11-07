import java.util.Scanner;
import java.util.HashMap;
public class TransactionMonitoringSystem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Character, Character> transactionMap = new HashMap<>();
        int prevTimestamp = 0;
        for(int i = 1; i <= n; i++) {
            char sender = sc.next().charAt(0);
            char receiver = sc.next().charAt(0);
            int timestamp = sc.nextInt();
            int amount = sc.nextInt();
            // check in map, if sender not present or not same receiver then add to map
            if(!transactionMap.containsKey(sender) || (transactionMap.get(sender) != receiver)) {
                transactionMap.put(sender, receiver);
            } else {
                System.out.println("Error: Duplicate Transaction");
                break;
            }
            
            if(prevTimestamp != 0 && timestamp - prevTimestamp > 60) {
                System.out.println("Fraud Detected");
                break;
            }
            prevTimestamp = timestamp;

            if(i == n) {
                System.out.println("All Transactions Valid");
            }
        }
    }
}
