package Class;
import java.util.ArrayList;
public class LexicographicalNumbers {

    static ArrayList<Integer> result = new ArrayList<>();

    public static void f(int i, int n) {

        if(i <= n) {
            result.add(i);
        } else {
            return;
        }
        
        for(int k = 0; k <= 9; k++) {
            if(i == 0 && k == 0) continue;
            f(10 * i + k, n);
        }
    }
    
    public static void main(String[] args) {
        result.clear();
        f(0, 1003);
        for(int elem : result) {
            System.out.print(elem + " ");
        }
    }
}
