import java.util.Scanner;
public class CapitalUsage {

    public static boolean capitalUsage(String str) {
        if(str.length() == 0) return true;
        int count = 0;
        for(char ch : str.toCharArray()) {
            if(ch >= 65 && ch <= 90) {
                count++;
            }
        }

        if(count == str.length() || count == 0 || (count == 1 && (str.charAt(0) >= 65 && str.charAt(0) <= 90))) {
            return true;
        }

        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        String word3 = sc.next();
        System.out.println(capitalUsage(word1));
        System.out.println(capitalUsage(word2));
        System.out.println(capitalUsage(word3));
    }
}
