
import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        User obj = new User();
        while(true)
        {
            System.out.println();
            System.out.println("1.Enter Pin");
            System.out.println("2.User Register");

            int n = sc .nextInt();
            int acc = 0;
            switch(n)
            {
                case 1:
                    System.out.println("Enter your acc number");
                    acc = sc.nextInt();
                    System.out.println("Enter your Pin number");
                    int pin = sc.nextInt();
                    obj.Check(acc,pin);
                    break;
                case 2:
                    System.out.println("Create your account Number");
                    acc = sc.nextInt();
                    System.out.println("Account Holder Name");
                    String name = sc.next();
                    System.out.println("Please create a Pin");
                    int newpin = sc.nextInt();
                    obj.Insert(acc,newpin,name);
                    break;
                default :
                    System.out.println("Select valid number");
                    break;
            }
        }

    }
}