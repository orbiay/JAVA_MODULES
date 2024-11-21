import java.util.Scanner;
class Program {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.print("Hi There Could u share with us ur Number: \n ->");
        int number = scan.nextInt();
        if (number <= 1)
        {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        else
        {
            int op = 1;
            for (int i = 2; i * i <= number ; i++)
            {
                if (number % i == 0)
                {
                    System.out.print("false ");
                    System.out.println(op);
                    System.exit(0);
                }
                op++;
            }
            System.out.print("true ");
            System.out.println(op);
        }
    }
    
}
/*When determining whether a number is prime, you only need to check for divisors up to its square root, because if a number nn has a divisor larger than nn
​, then it must also have a corresponding divisor smaller than |/n
 */