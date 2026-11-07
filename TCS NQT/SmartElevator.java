import java.util.Scanner;
public class SmartElevator {

    public static int smartElevator(int requests[]) {
        int time = 0;
        for(int i = 0; i < requests.length; i++) {
            if(i == 0) {
                if(requests[i] == 0) {
                    time += 1;
                } else {
                    time += (requests[i] * 2) + 1;
                }
            } else {
                if(requests[i] == requests[i - 1]) {
                    time += 1;
                } else {
                    time += (Math.abs(requests[i] - requests[i - 1]) * 2) + 1;
                }
            }
        }
        return time;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int requests[] = new int[n];
        for(int i = 0; i < n; i++)
            requests[i] = sc.nextInt();
        System.out.println(smartElevator(requests));
    }
}
