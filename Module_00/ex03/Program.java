import java.util.Scanner;

class Program {
    static int startweek = 0;
    static public long powOfTeen(int times)
    {
        long power = 1;
        for (int i = 0;i < times;i++)
        {
            power *= 10;
        }
        return power;
    }
    static public int firstLineHandler(Scanner scan,int numOfWeeks)
    {
        System.out.print("--> ");
        String line = scan.next();
        if (line.equals("42"))
            return -1;
        int number = scan.nextInt();
        if (numOfWeeks == 0)
        {
            startweek = number;
            numOfWeeks = number;
        }
        if (!line.equals("Week") || numOfWeeks != number || number > 18 || number < 1)
        {
            System.err.print("llegalArgument");
            System.exit(-1);
        }
        return numOfWeeks;
    }
    static public long secondLineHandler(Scanner scan,long minims)
    {
        System.out.print("--> ");
        int saver = scan.nextInt();
        int min = saver;
        for (int i = 0; i < 4; i++) {
            saver = scan.nextInt();
            if (saver > 9 || saver < 1 || min > 9 || min < 1)
            {
                System.err.print("llegalArgument");
                System.exit(-1);
            }
            if (saver < min)
                min = saver;
        }
        minims *= 10;
        minims += min;
        return minims;
    }
    static public void theChart(int numOfEquals)
    {
        System.out.print("  Week ");
        System.out.print(startweek);
        System.out.print("  ");
        while(numOfEquals > 0)
        {
            System.out.print("=");
            numOfEquals--;
        }
        System.out.println(">");
        startweek++;
    }
    static public void printTheChart(int count,long minims)
    {
        long number = powOfTeen(count);
        int saver = 0;
        while (number > 0 )
        {
            saver =(int) (minims / number);
            minims -= saver * number;
            number /= 10;
            theChart(saver);
            count--;
        }
    }
    static public void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int numOfWeeks = 0;
        long minims = 0 ;
        int inCase = 0;
        int count = -1;
        while (true)
        {

            inCase = firstLineHandler(scan,numOfWeeks);
            if (inCase != -1)
                numOfWeeks = inCase;
            else
                break;
            minims =  secondLineHandler(scan,minims);
            numOfWeeks++;
            count++;
        }
        printTheChart(count,minims);
    }
}