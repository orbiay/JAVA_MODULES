import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        try{
            if(args.length != 1 || !args[0].startsWith("--profile="))
            {
                System.out.println("Somthing Wrong with your arguments");
                return ;
            }
            String mode = args[0].substring("--profile=".length());
            boolean modeBoolean = false;
            if (mode.equals("DEV"))
                modeBoolean = true;
            else if (!mode.equals("PROD"))
            {
                System.out.println("Somthing Wrong with your arguments");
                return ;
            }
            Menu menu = new Menu(new TransactionsService(),modeBoolean);
            menu.entry();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
