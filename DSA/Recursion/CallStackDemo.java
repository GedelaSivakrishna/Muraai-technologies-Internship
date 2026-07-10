public class CallStackDemo {

    public static void f() {
        int i = 0;
        System.out.println(i);
    }

    public static int g() {
        int j = 0;
        return j;
    }
    

    public static void main(String[] args) {
        f();
        int x = g();
        System.out.println(x);
    }
}
