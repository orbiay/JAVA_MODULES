import java.util.Scanner;

class Program {
    static public boolean countFrequency(String input,int frequency[])
    {
        char[] chars = input.toCharArray();
        if (input.length() == 0 )
            return false;
        for(char chare : chars)
            frequency[chare]++;
        return true;
    }
    static public void sortByFrequency(char[] asAchar,int[] aboveZero,int counter)
    {
        int saverInt = 0;
        char saverChar;
        for (int i = 0;i < counter ;i++)
        {
            for (int j = i + 1;j < counter;j++)
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
                if (aboveZero[i] == aboveZero[j]  && (int)asAchar[i] > (int)asAchar[j])
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
        int minLength = counter;
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
                if (chart[i] > rows)
                    System.out.print("   #   ");
                else if (chart[i] == rows)
                {
                    System.out.print("   " );
                    System.out.print(aboveZero[i]);
                    System.out.print("   ");
                }
                else
                    System.out.print("   ");
               
            }
            rows--;
            System.out.println();
        }
        for (int i = 0;i < counter;i++)
        {
            System.out.print("   " );
            System.out.print(asAchar[i]);
            System.out.print("   ");
        }

    }
    static public void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(" -> :  ");
        String input = scan.nextLine();
        int frequency[] = new int[65536];
        if (!countFrequency(input,frequency))
        {
            System.err.println("Error :Fix Your input");
            return;
        }
        char[] asAchar = new char[65536];
        int[] aboveZero = new int[65536];
        int counter = 0;
        for (int i = 0;i < 65536;i++)
        {
            if (frequency[i] > 0)
            {
                asAchar[counter] = (char) i;
                aboveZero[counter] = frequency[i];
                counter++;
            }
        }
        sortByFrequency(asAchar,aboveZero,counter);
        if(counter > 10)
            counter = 10;
        printingChart(asAchar,aboveZero,counter);

    }
}
//प्रोग्रामिंगकीदुनियामेंआपकास्वागतहै!प्रोग्रामिंगमजेदारऔररोमांचकहै।
//مرحبًابكمفيعالمالبرمجة!البرمجةممتعةومثيرة 