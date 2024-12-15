package javaa.fr.fortytwo.printer.logic;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ConvertLogic {
    private StringBuilder res;
    private char white;
    private char black;
    private String path;
    public ConvertLogic(char white,char black , String path)
    {
        this.white = white;
        this.black = black;
        this.path = path;
        res = new StringBuilder();
    }
    private static boolean isBlack(int pixel) {
        int red = (pixel >> 16) & 0xFF;
        int green = (pixel >> 8) & 0xFF;
        int blue = pixel & 0xFF;

        double luminance = 0.2126 * red + 0.7152 * green + 0.0722 * blue;

        return luminance < 128;
    }

    public StringBuilder readAndFill()
    {
        try{
            BufferedImage image = ImageIO.read(new File(this.path));
            if (image.getWidth() > 16 || image.getWidth() < 16 || image.getHeight() > 16 || image.getHeight() < 16)
                throw new ImageWidtheigthException("Error: Image Width Heigth Exception");
            for (int x = 0 ; x < 16;x++)
            {
                for (int y = 0; y < 16 ;y++)
                {
                    int pixel = image.getRGB(x,y);
                    if(isBlack(pixel))
                        res.append(black);
                    else
                        res.append(white);
                }
                res.append("\n");
            }
        }catch (Exception e)
        {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        return res;
    }
    
}
/*
public final class ImageIO
extends Object
A class containing static convenience methods for locating ImageReaders and ImageWriters, and performing simple encoding and decoding
 */