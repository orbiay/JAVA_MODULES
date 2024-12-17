package fr.fortytwo.printer.logic;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;


public class ConvertLogic {
    private StringBuilder res;
    private String white;
    private String black;
    private InputStream input;


    public ConvertLogic(String white,String black , InputStream input)
    {
        this.white = white;
        this.black = black;
        this.input = input;
        res = new StringBuilder();
    }
    private static boolean isBlack(int pixel) {
        int red = (pixel >> 16) & 0xFF;
        int green = (pixel >> 8) & 0xFF;
        int blue = pixel & 0xFF;

        double luminance = 0.2126 * red + 0.7152 * green + 0.0722 * blue;

        return luminance < 128;
    }
    private Attribute getColorFromName(String colorName) {
        switch (colorName.toUpperCase()) {
            case "RED":
                return Attribute.BACK_COLOR(255, 0, 0); // Red
            case "GREEN":
                return Attribute.BACK_COLOR(0, 255, 0); // Green
            case "BLUE":
                return Attribute.BACK_COLOR(0, 0, 255); // Blue
            case "YELLOW":
                return Attribute.BACK_COLOR(255, 255, 0); // Yellow
            case "WHITE":
                return Attribute.BACK_COLOR(255, 255, 255); // White
            case "BLACK":
                return Attribute.BACK_COLOR(0, 0, 0); // Black
            default:
                return Attribute.BACK_COLOR(128, 128, 128); // Default gray background
        }
    }
    public void readAndFill()
    {
        
        try{
            BufferedImage image = ImageIO.read(input);
            if (image.getWidth() > 16 || image.getWidth() < 16 || image.getHeight() > 16 || image.getHeight() < 16)
                throw new ImageWidtheigthException("Error: Image Width Heigth Exception");
            for (int x = 0 ; x < 16;x++)
            {
                for (int y = 0; y < 16 ;y++)
                {
                    int pixel = image.getRGB(x,y);
                    if(isBlack(pixel))
                    
                        System.out.print(Ansi.colorize(" ", getColorFromName(black)));
                    else
                        System.out.print(Ansi.colorize(" ", getColorFromName(white)));
                }
                System.out.println();
            }
        }catch (Exception e)
        {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }
    
}
/*
public final class ImageIO
extends Object
A class containing static convenience methods for locating ImageReaders and ImageWriters, and performing simple encoding and decoding
 */