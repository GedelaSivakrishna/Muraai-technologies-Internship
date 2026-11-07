import java.util.Scanner;
public class LexicographicalColumns {

    public static int countNonLexicographicalColumns(String[] strs) {
        if(strs.length == 0) return 0;
        int rows = strs.length;
        int cols = strs[0].length();
        int count = 0;
        
        for(int i = 0; i < cols; i++) { // traversing cols
            for(int j = 1; j < rows; j++) { // traversing rows
                if(strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        // take Strings i/p
        for(int i = 0; i < n; i++)
            strs[i] = sc.next();
        System.out.println(countNonLexicographicalColumns(strs));
    }
}
