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
            System.out.println(number);
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