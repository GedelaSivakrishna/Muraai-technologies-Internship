import java.util.Scanner;
public class SoldierArrangement {

    static int ways = 0;
	
	public static void f(int N, int end, int R, String output) {
		if(output.length() == N - 1) {
			// output += end;
			// System.out.print(output + " ");
            ways++;
			return;
		}

		for(int i = 1; i <= R; i++) {
			char lastChar = output.charAt(output.length() - 1);
			if(lastChar - '0' != i) {
				if(output.length() == N - 2 && i == end) {
					continue;
				}
				f(N, end, R, output + i);
			}
		}
	}	

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int end = sc.nextInt();
		int R = sc.nextInt();
        ways = 0;
		f(N, end, R, "1");
	}
}