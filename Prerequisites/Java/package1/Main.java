package package1;
import package2.BankAccount;

public class Main {
    
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        System.out.println(account.bankName);
        
    }

}

class MainSub extends BankAccount {
    public static void main(String[] args) {
        MainSub s = new MainSub();
        // s.
    }
}