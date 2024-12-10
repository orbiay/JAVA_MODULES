class Main {
    static public void main(String args[])
    {
        try{
            if (args.length < 1 || !args[0].startsWith("--count="))
            {
                System.out.println("You must enter times.");
                return ;
            }
            int count = Integer.parseInt(args[0].substring("--count=".length()));
            ThreadNum01 threadEgg = new ThreadNum01(count);
            ThreadNum02 implementThread = new ThreadNum02(count);
            Thread threadHenn = new Thread(implementThread);
            threadEgg.start();
            threadHenn.start();
            try {
                threadEgg.join();
                threadHenn.join();
            } catch (InterruptedException e) {
                System.err.println("Main thread interrupted.");
            }
            int i = 0;
            while(i < count)
            {
                System.out.println("Human");
                i++;
            }
            System.out.println("The Main Thread has been Done");
        }catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}