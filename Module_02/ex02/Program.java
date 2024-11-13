import java.util.*;
class Program {
    private static String HOME = System.getProperty("user.home");

    static public void main(String args[])
    {
        if(args.length < 1 || !args[0].startsWith("--current-folder="))
        {
            System.out.println("Somthing Wrong with your arguments");
            return ;
        }
        Scanner scan = new Scanner(System.in);

        System.out.println(HOME);
        String initialePath = args[0].substring("--current-folder=".length());
        FileManager fileManger = new FileManager(initialePath);
        while(true)
        {
            System.out.print("-->");
            String line = scan.nextLine().trim();
            fileManger.commandHandler(line);
        }
    }
}