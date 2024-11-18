import java.io.BufferedReader;
import java.io.*;
import java.net.URL;
class ThreadMember extends Thread {
    static private int creationThread;
    static public int fileNumber;
    private int numberOfThread;
    ThreadMember()
    {
        numberOfThread = ++creationThread;
    }
    public void startWorkingOn()
    {
        System.out.println("Thread-"+ numberOfThread + " start download file number " + fileNumber);
    }
    public void workedFile()
    {
        System.out.println("Thread-"+ numberOfThread + " finish download file number " + fileNumber);
    }
    public void run()
    {
        
        int i = 0;
        String stringUrl;
        try{
            while (Main.deque.size() > 0)
            {
                System.out.println(numberOfThread);
                synchronized(Main.deque)
                {
                    if (Main.deque.size() > 0)
                    {
                        stringUrl = Main.deque.poll();
                        System.out.println("------------>" + Main.deque.size());
                        System.out.println("Worked File is " + stringUrl);
                        ++fileNumber;
                        FileOutputStream fileOutputStream = new FileOutputStream("file" + fileNumber + ".txt");
                        URL url = new URL(stringUrl);
                        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

                        String inputLine;
                        startWorkingOn();
                        while ((inputLine = in.readLine()) != null) {
                            fileOutputStream.write(inputLine.getBytes());

                        }
                        in.close();
                        workedFile();
                    }
                }
            }
        }catch(Exception e)
        {

        }
    }
}