class ThreadNum02 implements Runnable {
    private int times;
    ThreadNum02(int count)
    {
        times = count;
    }
    public void run()
    {
        int i = 0;
        while ( i < times)
        {
            System.out.println("Hen");
            i++;
        }
    }
}