class Program {
    public static void main(String arg[])
    {
        int number = 479598;
        int sum = 0;
        sum += number / 100000;
        number = number % 100000;
        sum += number / 10000;
        number = number % 10000;
        sum += number / 1000;
        number = number % 1000;
        sum += number / 100;
        number = number % 100;
        sum += number / 10;
        number = number % 10;
        sum += number;
        System.out.print(sum + " " + number);
    }
}