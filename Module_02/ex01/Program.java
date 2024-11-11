import java.io.*;
import java.util.*;

class Program {
    public static String readFile(String fileName)
    {
        String stringBuffer = "";
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader buffer = new BufferedReader(fileReader);
            while (buffer.ready()) {
                String line = buffer.readLine();
                stringBuffer += line;
                stringBuffer += " ";
            }
            fileReader.close();
        }catch(Exception e)
        {
        }
        return stringBuffer;
    }
    public static Map<String,Integer> stringToMap(String fileContent)
    {
        String sp[] = fileContent.split(" ");
        Map<String,Integer> retMap = new HashMap();
        for (int i = 0; i < sp.length ; i++)
        {
            if (retMap.get(sp[i]) == null)
                retMap.put(sp[i],1);
            else
                retMap.put(sp[i] , retMap.get(sp[i]) + 1);
        }
        return retMap;
    }
    static public HashSet<String> StringToSet(String content)
    {
        String sp[] = content.split(" ");
        HashSet<String> newSet = new HashSet();
        for (int i = 0;i < sp.length; i++)
        {
            newSet.add(sp[i]);
            System.out.println(sp[i]);
        }
        return newSet;
    }
    static public void main(String args[])
    {
        System.out.println(args.length);
        if (args.length > 1)
        {
            String file1 = readFile(args[0]);
            String file2 = readFile(args[1]);
            System.out.println("file 1 is " + file1 + "\n file2 is " + file2);
            String words = file1 + " " + file2;
            Map<String,Integer>  mapFile1 = stringToMap(file1);
            Map<String,Integer>  mapFile2 = stringToMap(file2);
            HashSet<String> setOfUniqueStrings = StringToSet (file1 +" " + file2);

        }
    }
}