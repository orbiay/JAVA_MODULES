class ThreadMember extends Thread {
    private int assignedSize;
    private int start;
    private static int numofInstances;
    private int threadNumber;
    private int localSum;
    ThreadMember(int assignedSize,int start)
    {
        this.assignedSize = assignedSize;
        this.start = start;
        threadNumber = ++numofInstances;
    }
    public void defineYourSelf()
    {
        System.out.println("Thread "+ threadNumber + ": from " + start + " to  "+ (start + assignedSize ) + " sum is " + localSum);
    }
    public void run()
    {
        int i = 0;
        while (i < assignedSize)
        {
            synchronized(Main.lock)
            {
                Main.sum += Main.output[start + i];
                localSum += Main.output[start + i];
                i++;
            }
        }
    }
}