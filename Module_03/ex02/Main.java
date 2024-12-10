import java.util.Random;

class Main {
    public static int[] output;
    public static int capacity;
    public static int sum = 0;
    public static final Object lock = new Object(); 
    static public void generateRandomValues()
    {
        Random random = new Random();
        int manuel = 0;
        for (int i = 0;i < capacity;i++)
        {
            output[i] = random.nextInt(1001);
            manuel += output[i];
        }
        System.out.println(manuel);
    }
    static public void main(String args[])
    {
        if (args.length < 2 || !args[0].startsWith("--arraySize=") || !args[1].startsWith("--threadsCount="))
        {
            System.out.println("Error: error in arguments.");
            return ;
        }
        try{
            int arrayLength = Integer.parseInt(args[0].substring("--arraySize=".length()));
            int numOfThreads = Integer.parseInt(args[1].substring("--threadsCount=".length()));
            if (arrayLength < numOfThreads)
            {
                System.out.println("Error: could u fix your input.");
                return ;
            }
            capacity = arrayLength;
            output = new int[capacity];
            generateRandomValues();
            int assignedSize = arrayLength / numOfThreads;
            for (int i = 0; i < numOfThreads;i++)
            {
                ThreadMember thread;
                if (i + 1 == numOfThreads  && assignedSize < arrayLength )
                    thread = new ThreadMember(arrayLength,i * assignedSize);
                else if (assignedSize < arrayLength)
                    thread = new ThreadMember(assignedSize,i * assignedSize);
                else
                    thread = new ThreadMember(arrayLength,i* assignedSize);
                thread.start();
                thread.join();
                thread.defineYourSelf();
                arrayLength -= assignedSize;

            }
            System.out.println("Sum by Threads : " + sum);
        }catch(Exception e)
        {

        }
    }
}