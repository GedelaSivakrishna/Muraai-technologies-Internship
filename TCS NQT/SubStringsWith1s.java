import java.util.Scanner;
public class SubStringsWith1s {

    public static boolean allSetBits(String substr) {
        int count = 0;
        for(char ch : substr.toCharArray()) {
            if(ch == '1') count++;
        }
        return count == substr.length();
    }

    public static int substringsWith1s(String str) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            for(int j = i; j < str.length(); j++) {
                String substr = str.substring(i, j + 1);
                if(allSetBits(substr)) {
                    count++;
                    continue;
                }
                break;
            }
        }

        return count;
    }
    
    public static int countSubStringsWith1s(String str) {
        int result = 0;
        int count = 0;

        for(char ch : str.toCharArray()) {
            if(ch == '1') count++;
            else {
                // update result
                result += (count * (count + 1)) / 2;
                // reset count
                count = 0;
            }
        }
        result += (count * (count + 1)) / 2;
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // System.out.println(substringsWith1s(str));
        System.out.println(countSubStringsWith1s(str));
    }
}
