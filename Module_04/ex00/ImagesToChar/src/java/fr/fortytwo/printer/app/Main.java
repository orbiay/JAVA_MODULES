import java.util.Scanner;
import java.fr.fortytwo.printer.logic.ConvertLogic;
class Main {
    static public void main (String args[])
    {
        try{
            if (args.length != 3 || args[0].length() != 1 || args[1].length() != 1)
                System.err.println("Error :Fix Your Parameters");
            System.out.println("vvvv");
            ConvertLogic convert = new ConvertLogic(args[0].charAt(0),args[1].charAt(0),args[2]);
            String result = convert.readAndFill().toString();
            System.out.println("result");
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}