class Main {
    public static String[] output;
    static public void main(String args[])
    {
        if (args.length < 1 || !args[0].startsWith("--count="))
        {
            System.out.println("You must enter times.");
            return ;
        }
        int count = Integer.parseInt(args[0].substring("--count=".length()));
        output = new String[count * 2];
        ThreadNum01 threadEgg = new ThreadNum01(count,output);
        ThreadNum02 implementThread = new ThreadNum02(count,output);
        Thread threadHenn = new Thread(implementThread);
        threadEgg.start();
        threadHenn.start();
        try {
            threadEgg.join(); 
            threadHenn.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 0;
        while(i < count * 2)
        {
            System.out.println(output[i]);
            i++;
        }
        System.out.println("The Main Thread has benne Done :]");
    }
}