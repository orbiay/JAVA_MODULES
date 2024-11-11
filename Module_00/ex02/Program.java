import java.util.Scanner;

class Program {
    static public boolean isPrime(int number){
        if (number <= 1)
            System.err.println("IllegalArgument");

        else
        {
            for (int i = 2; i * i <= number ; i++)
            {
                if (number % i == 0)
                    return false;
            }
        }
        return true;
    }
    static public double sumOfSet(double number)
    {
        double sum = 0;
        
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
    static public void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        double number = 0;
        int counter = 0;
        while (number != 42)
        {
            System.out.print("--> ");
            number = scan.nextDouble();
            if (isPrime((int) sumOfSet(number)))
                counter += 1;
        }
        System.out.println("Count of coffee-request : " + counter);
    }
}