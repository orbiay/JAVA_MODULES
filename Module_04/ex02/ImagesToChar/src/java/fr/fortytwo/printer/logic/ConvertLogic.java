package fr.fortytwo.printer.logic;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import com.diogonunes.jcolor.FColor;
import com.diogonunes.jcolor.BColor;

public class ConvertLogic {
    private StringBuilder res;
    private String white;
    private String black;
    private InputStream input;

 public static FColor getForegroundColor(String colorName) {
        switch (colorName.toUpperCase()) {
            case "RED":
                return FColor.RED;
            case "GREEN":
                return FColor.GREEN;
            case "BLUE":
                return FColor.BLUE;
            case "YELLOW":
                return FColor.YELLOW;
            case "CYAN":
                return FColor.CYAN;
            case "MAGENTA":
                return FColor.MAGENTA;
            case "WHITE":
                return FColor.WHITE;
            case "BLACK":
                return FColor.BLACK;
            default:
                return FColor.DEFAULT; // Default color if not found
        }
    }

    // Method to convert string to BColor
    public static BColor getBackgroundColor(String colorName) {
        switch (colorName.toUpperCase()) {
            case "RED":
                return BColor.RED;
            case "GREEN":
                return BColor.GREEN;
            case "BLUE":
                return BColor.BLUE;
            case "YELLOW":
                return BColor.YELLOW;
            case "CYAN":
                return BColor.CYAN;
            case "MAGENTA":
                return BColor.MAGENTA;
            case "WHITE":
                return BColor.WHITE;
            case "BLACK":
                return BColor.BLACK;
            default:
                return BColor.DEFAULT; // Default color if not found
        }
    }

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

    public void readAndFill()
    {
        String whiteText = Ansi.colorize(" ", Attribute.BACK_COLOR(Ansi.BColor.GREEN));
        String blackText =Ansi.colorize(" ", Attribute.GREEN_TEXT());
        FColor foreground = getForegroundColor(black);
        BColor background = getBackgroundColor(white);
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
                        System.out.print(Ansi.colorize(" ", Attribute.FOREGROUND_COLOR(foregroundColor)));
                    else
                        System.out.print(Ansi.colorize(" ", Attribute.BACK_COLOR(backgroundColor)));
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