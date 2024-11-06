import java.util.Scanner;

class Program {
    static public void countFrequency(String input,int frequency[])
    {
        char[] chars = input.toCharArray();
        for(char chare : chars)
            frequency[chare]++;
    }
    static public void sortByFrequency(char[] asAchar,int[] aboveZero,int counter)
    {
        int saverInt = 0;
        char saverChar;
        for (int i = 0;i < counter - 1;i++)
        {
            for (int j = 1;j < counter;j++)
            {
                if (aboveZero[i] < aboveZero[j])
                {
                    saverInt = aboveZero[i];
                    aboveZero[i] = aboveZero[j];
                    aboveZero[j] = saverInt;
                    saverChar = asAchar[i];
                    asAchar[i] = asAchar[j];
                    asAchar[j] = saverChar;
                }
                // else if (aboveZero[i] == aboveZero[j] && (int) asAchar[i] > (int) asAchar[j])
                // {
                //     saverInt = aboveZero[i];
                //     aboveZero[i] = aboveZero[j];
                //     aboveZero[j] = saverInt;
                //     saverChar = asAchar[i];
                //     asAchar[i] = asAchar[j];
                //     asAchar[j] = saverChar;
                // }
            }
        }
    }
    static public void printingChart(char[] asAchar,int[] aboveZero,int counter)
    {
        // int rows = counter;
        // int columns = 0;
        int maxFrequency = aboveZero[0];
        int chartScailling  = 1;
        int[] isItPrinted = new int[counter];
        for (int i = 0;i < counter;i++)
            isItPrinted[i] = -1;
        if (maxFrequency / 10 > 0)
            chartScailling = maxFrequency / 10;
        for (int rows = 10 ; rows > 0 ; rows--)
        {
            for (int i = 0; i < counter; i++)
            {
                if (aboveZero[i] / chartScailling == rows -1 && isItPrinted[i] == -1)
                {
                    System.out.print("  "+ aboveZero[i] +"  ");
                    isItPrinted[i] = 1;
                }
                if (aboveZero[i] / chartScailling >= rows)
                    System.out.print("  #  ");
                // if (rows - 1 == 0)
                //     System.out.print(asAchar[i]);
                else
                    System.out.print("     ");
            }
            System.out.println();
        }
        for (int i = 0;i < counter;i++)
            System.out.print("  " + asAchar[i] + "  ");

    }
    static public void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(" -> :  ");
        String input = scan.nextLine();
        System.out.println("\n\n\n\n\n\n" + input);
        int frequency[] = new int[65536];
        countFrequency(input,frequency);
        // for (int i = 0; i < 100;i++ )
        //     System.out.println(frequency[i]);
        char[] asAchar = new char[65536];
        int[] aboveZero = new int[65536];
        int counter = 0;
        for (int i = 0;i < 65536;i++)
        {
            if (frequency[i] > 0)
            {
                asAchar[counter] = (char) i;
                aboveZero[counter] = frequency[i];
                // System.out.println(asAchar[i]);
                counter++;
            }
        }
        sortByFrequency(asAchar,aboveZero,counter);
        // for (int i = 0;i < counter;i++)
        // {
        //     System.out.println(asAchar[i] + " " + aboveZero[i]);
        // }
        printingChart(asAchar,aboveZero,counter);

    }
}