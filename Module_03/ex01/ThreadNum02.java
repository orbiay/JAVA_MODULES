class ThreadNum02 implements Runnable {
    private int times;
    String[] output;
    ThreadNum02(int count,String[] output)
    {
        times = count;
        this.output = output;
    }
    public  void run()
    {
        int i = 1;
        while (i < times * 2)
        {
            synchronized(output)
            {
                output[i] = "Hen" ;
                i+=2;
            }
        }
    }
}