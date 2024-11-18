
import java.util.ArrayDeque;
import java.util.Deque;
import java.io.*;
class Main {
    // public static final Object lock = new Object(); 
    public static Deque<String> deque = new ArrayDeque<String>();
    public static void readFromUrl(int numOfThreads)
    {
        try{
            for (int i = 0; i < numOfThreads;i++)
            {
                System.out.println(i+1);
                ThreadMember thread = new ThreadMember();
                thread.start();
            }
        }catch(Exception e)
        {

        }
    }
    static public void main(String args[])
    {
        if (args.length < 1 || !args[0].startsWith("--threadsCount="))
        {
            System.out.println("Error: error in argument.");
            return ;
        }
        try{
            int numOfThreads = Integer.parseInt(args[0].substring("--threadsCount=".length()));
            File file = new File("files_urls.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fileReader);
            while (buffer.ready()) {
                String line = buffer.readLine();
                deque.add(line);
            }
            fileReader.close();
            readFromUrl(numOfThreads);
        }catch(Exception e)
        {

        }
    }
}