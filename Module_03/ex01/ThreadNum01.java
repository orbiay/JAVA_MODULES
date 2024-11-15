class ThreadNum01 extends Thread {
    private int times;
    String[] output;
    ThreadNum01(int count,String[] output)
    {
        times = count;
        this.output = output;
    }
    public void run()
    {
        int i = 0;
        while (i < times * 2)
        {
            synchronized(output)
            {
                output[i] = "Egg";
                i += 2;
            }
        }
    }
}