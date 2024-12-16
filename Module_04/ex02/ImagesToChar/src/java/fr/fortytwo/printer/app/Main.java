package fr.fortytwo.printer.app;
import java.util.*;
import fr.fortytwo.printer.logic.ConvertLogic;
import java.io.InputStream;
class Main {
    static public void main (String args[])
    {
        try{
            if (args.length != 2 || args[0].length() != 1 || args[1].length() != 1)
                System.err.println("Error :Fix Your Parameters");
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("resources/it.bmp");
            ConvertLogic convert = new ConvertLogic(args[0].charAt(0),args[1].charAt(0),inputStream);
            String result = convert.readAndFill().toString();
            System.out.println(result);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}