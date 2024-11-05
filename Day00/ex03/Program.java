import java.util.Scanner;

class Program {
    static int startweek = 0;
    static public int powOfTeen(int times)
    {
        int power = 1;
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
        if (!line.equals("week") || numOfWeeks != number || number > 18 || number < 1)
        {
            System.err.print("llegalArgument");
            System.exit(-1);
        }
        return numOfWeeks;
    }
    static public int secondLineHandler(Scanner scan,int minims)
    {
        int saver = scan.nextInt();
        int min = saver;
        for (int i = 0; i < 4; i++) {
            saver = scan.nextInt();
            if (saver > 9)
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
        System.out.print("  week " + startweek + "  ");
        while(numOfEquals > 0)
        {
            System.out.print("=");
            numOfEquals--;
        }
        System.out.println(">");
        startweek++;
    }
    static public void printTheChart(int count,int minims)
    {
        int number = powOfTeen(count);
        int saver = 0;

        while (number > 0)
        {
            saver = minims / number;
            minims -= saver * number;
            number /= 10;
            theChart(saver);
        }
    }
    static public void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int numOfWeeks = 0;
        int minims = 0 ;
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