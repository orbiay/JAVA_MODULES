import java.util.*;
class Program {

    static public void main(String args[])
    {
        try{
            if(args.length < 1 || !args[0].startsWith("--current-folder=") || "--current-folder=".length() >= args[0].length())
            {
                System.out.println("Somthing Wrong with your arguments");
                return ;
            }
            Scanner scan = new Scanner(System.in);

            String initialePath = args[0].substring("--current-folder=".length());
            FileManager fileManger = new FileManager(initialePath);
            while(true)
            {
                System.out.print("-->");
                String line = scan.nextLine().trim();
                fileManger.commandHandler(line);
            }
        }catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}