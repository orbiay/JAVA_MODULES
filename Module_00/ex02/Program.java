import java.util.Scanner;

class Program {
    static public boolean isPrime(int number){

        for (int i = 2; i * i <= number ; i++)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }
    static public long sumOfSet(long number)
    {
        long sum = 0;
        
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
    static public void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        long number = 0;
        int counter = 0;
        while (number != 42)
        {
            System.out.print("--> ");
            number = scan.nextLong();
            if (number <= 1)
                System.err.println("IllegalArgument");
            else if (isPrime((int) sumOfSet(number)))
                counter += 1;
        }
        System.out.print("Count of coffee-request : ");
        System.out.println(counter);
    }
}