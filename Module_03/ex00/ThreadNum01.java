class ThreadNum01 extends Thread {
    private int times;
    ThreadNum01(int count)
    {
        times = count;
    }
    public void run()
    {
        int i = 0;
        while (i < times)
        {
            System.out.println("Egg");
            i++;
        }
    }
}