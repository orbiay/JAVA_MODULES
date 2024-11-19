import java.util.Scanner;

class Program {
    static public boolean countFrequency(String input,int frequency[])
    {
        char[] chars = input.toCharArray();
        if (input.length() == 0 || (input.length() >= 2 && input.charAt(input.length() - 1) != '2' && input.charAt(input.length() - 2) != '4'))
            return false;
        for(char chare : chars)
        {
            if(chare == '4' || chare == '2')
                continue;
            frequency[chare]++;
        }
        return true;
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
            }
        }
    }
    static public int minLength(int[] aboveZero)
    {
        int i;
        for (i = 0;i < 10;i++)
        {
            if (aboveZero[i] == 0)
                break;
        }
        return i;
    }
    static public void printingChart(char[] asAchar,int[] aboveZero,int counter)
    {

        int maxFrequency = aboveZero[0];
        int minLength = minLength(aboveZero);
        int[] chart = new int[minLength];
        for (int i = 0;i < minLength;i++)
        {
            if (maxFrequency > 10)
            {
                int value = (aboveZero[i] * 10) / maxFrequency;
                chart[i] = value;
            }
            else
                chart[i] = aboveZero[i];
        }
        int rows = chart[0];
        while(rows >= 0)
        {
            for (int i = 0 ; i < minLength;i++)
            {
                if (chart[i] == rows)
                    System.out.print("  " + aboveZero[i] + "  ");
                else if (chart[i] > rows)
                    System.out.print("  " + "#" + "  ");
            }
            rows--;
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
        System.out.println("\n\n\n\n\n\n" + input + "\n\n\n\n\n");
        int frequency[] = new int[65536];
        if (!countFrequency(input,frequency))
        {
            System.out.println("Error :Fix Your input");
            return;
        }
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