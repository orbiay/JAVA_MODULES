import java.io.*;
import java.util.*;

class Program {
    private static Map<String, String> fillMapFromOutputFile(FileInputStream fileInputStream)
    {
        int ch ;
        String fileExtention = "";
        boolean extentionFlag = false;
        String hexExtention = "";
        Map<String, String> map = new HashMap<>();
        try{
            while((ch = fileInputStream.read()) != -1)
            {
                if (ch != ',' && extentionFlag == false)
                    fileExtention += (char)ch;
                else if (ch == ',')
                    extentionFlag = true;
                else if (extentionFlag == true && ch != 32 && (char)ch != ',' && (char)ch != '\n')
                    hexExtention += (char)ch;
                else if ((char)ch == '\n')
                {
                    fileExtention = fileExtention + '\n';
                    map.put(fileExtention,hexExtention);
                    fileExtention = "";
                    hexExtention = "";
                    extentionFlag = false;
                }
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return map;
    }

    public static StringBuilder recognateFileExtention(String path)
    {
        StringBuilder hexHolder = new StringBuilder("");
        try{
            FileInputStream inputFile = new FileInputStream(path);
            byte[] firstSexteenByte = new byte[16];
            int bytes = inputFile.read(firstSexteenByte);
            if (bytes != -1 && inputFile.available() > 0)
            {
                for (byte singleByte : firstSexteenByte)
                {
                    hexHolder.append(String.format("%02X",singleByte));
                }
            }
            else
            {
                inputFile.close();
                return new StringBuilder("");
            }
            inputFile.close();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return hexHolder;
    }
    static public void main(String args[])
    {
        String inputFile = "signatures.txt";
        try{
            Map<String, String> map = new HashMap<>();
            FileInputStream  fileInputStream = new FileInputStream(inputFile);
            map = fillMapFromOutputFile(fileInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream("result.txt");
            Scanner scan = new Scanner(System.in);
            while(true)
            {
                System.out.print("-->");
                String line = scan.nextLine();
                if (line.equals("42"))
                {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return;
                }
                StringBuilder hexHolder = recognateFileExtention(line);
                if (hexHolder.toString() != "")
                {
                    map.forEach((key,value)->{
                        try{
                        if (hexHolder.toString().startsWith(value))
                            fileOutputStream.write(key.getBytes());
                        }catch(Exception e)
                        {
                            System.out.println(e.getMessage());
                        }
                        return ;
                    });
                    System.out.println("PROCESSED");
                }
                else
                    System.out.println("UNDEFINED");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}


/*
 * %: Indicates that you're specifying a format for the following value.
    0: This means the output should be padded with 0s if it has fewer than two characters.
    2: This means the output should have a minimum width of 2 characters.
    X: This converts the byte value into a hexadecimal representation in uppercase letters (i.e., A-F).
 */