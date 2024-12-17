package fr.fortytwo.printer.app;
import java.util.*;
import fr.fortytwo.printer.logic.*;
import java.io.InputStream;
import com.beust.jcommander.JCommander;

class Main {
    static public void buisnessLogic(String white, String black)
    {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("resources/it.bmp");
        ConvertLogic convert = new ConvertLogic(white,black,inputStream);
        convert.readAndFill();            
    }
    static public void main (String args[])
    {
        try{
            // if (args.length != 2 || args[0].length() != 1 || args[1].length() != 1)
            //     System.err.println("Error :Fix Your Parameters");
            ArgParser parsedArgs = new ArgParser();
            JCommander parser = JCommander.newBuilder()
                                  .addObject(parsedArgs)
                                  .build();
            parser.parse(args);
            buisnessLogic(parsedArgs.whiteColor,parsedArgs.blackColor);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}