package package2;

public class BankAccount {

    private String password;
    public String bankName = "HDFC";
    String branch = "Banglore";
    protected String pincode = "561200";

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public static void main(String[] args) {
        /* Encapsulation - Binding data and methods under a single unit. It protects the data by defining who
         *      can access it.
         */
        BankAccount account = new BankAccount();
        account.setPassword("pass123");
        // System.out.println(account.getPassword());

        /* Inheritance - one class extends the features of another class
         *  Types - 
         *      1) Single level - one child class extends the properties of a parent class
         *      2) Multi level - one parent class and child class and the cycle goes on
         *      3) Hierarchial - one parent & multiple child class inherit from same parent
         *      4) Hybrid - Combination of Multi level & Hierarchial 
         */
        Dog dog = new Dog();
        // dog.walks();

        /* Polymorphism - Many forms
         *      1) Method overloading (compile time) - same method with multiple parameters
         *      2) Method overriding (run time) - same method with different defination 
         */
        Calculator calculator = new Calculator();
        // System.out.println(calculator.sum(242, 240));
        // System.out.println(calculator.sum(240, 241, 242));
        // dog.walks();

        Windows windowsLaptop = new Windows();
        // windowsLaptop.processor();

        Mac macLaptop = new Mac();
        // macLaptop.processor();

    }

}

class Animal {

    public void walks() {
        System.out.println("Animal walks...");
    }

}

class Dog extends Animal {

    public void walks() {
        System.out.println("Dog walks with 4 legs..");
    }

}

class Calculator {

    public int sum(int n1, int n2) {
        return n1 + n2;
    }

    public int sum(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }

    public int sum(int n1, int n2, int n3, int n4) {
        return n1 + n2 + n3 + n4;
    }

}

 interface Laptop {
    
    public void processor();

}

class Windows implements Laptop {

    public void processor() {
        System.out.println("I have windows processor");
    }

}

class Mac implements Laptop {

    public void processor() {
        System.out.println("I have mac processor");
    }

}