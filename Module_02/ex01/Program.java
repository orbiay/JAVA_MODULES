import java.io.*;
import java.util.*;

class Program {
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10 MB
    public static String readFile(String fileName)
    {
        File file = new File(fileName);
        String stringBuffer = "";
        if (file.length() > MAX_FILE_SIZE)
            throw new maxExceedException("File Max is 10MB");
        try{
            FileReader fileReader = new FileReader(file);
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
            if(!sp[i].equals(""))
            {
                newSet.add(sp[i]);
                System.out.println(" =>" + sp[i] +"<=");
            }
        }
        return newSet;
    }
    static public void fillIntVecor(int vector[],int size,Map<String,Integer> map,HashSet<String> setOfWords)
    {
        int i = 0;
        for (String s:setOfWords)
        {
            if (map.get(s) == null)
                vector[i] = 0;
            else
                vector[i] = map.get(s);
            System.out.print(vector[i] + " , ");
            i++;
        }
        System.out.println();
    }
    static public int numerator(int[] vector1,int[] vector2,int size)
    {
        int ret = 0;
        for (int i = 0 ;i < size;i++)
        {
            System.out.println(vector1[i]);
            ret += vector1[i] * vector2[i];
        }
        return ret;
    }
    static public double denomina(int[] vector1,int[] vector2,int size)
    {
        int resVector1 = 0;
        int resVector2 = 0;
        for (int i = 0 ;i < size;i++)
            resVector1 += vector1[i] * vector1[i];
        for (int i = 0 ;i < size;i++)
            resVector2 += vector2[i] * vector2[i];
        return Math.sqrt(resVector1) * Math.sqrt(resVector2); 
    }
    static public void main(String args[])
    {
        System.out.println(args.length);
        if (args.length > 1)
        {
            String file1 = readFile(args[0]);
            String file2 = readFile(args[1]);
            // System.out.println("file 1 is " + file1 + "\n file2 is " + file2);
            String words = file1 + " " + file2;
            Map<String,Integer>  mapFile1 = stringToMap(file1);
            Map<String,Integer>  mapFile2 = stringToMap(file2);
            HashSet<String> setOfUniqueStrings = StringToSet (file1 +" " + file2);
            int[] file1Vector = new int[setOfUniqueStrings.size()];
            int[] file2Vector = new int[setOfUniqueStrings.size()];
            fillIntVecor(file1Vector,setOfUniqueStrings.size(),mapFile1,setOfUniqueStrings);
            for (int i = 0; i < setOfUniqueStrings.size();i++)
            {
                System.out.println( "-> " + file1Vector[i]);
            }
            fillIntVecor(file2Vector,setOfUniqueStrings.size(),mapFile2,setOfUniqueStrings);
            int numra = numerator(file1Vector,file2Vector,setOfUniqueStrings.size());
            double denomina = denomina(file1Vector,file2Vector,setOfUniqueStrings.size());
            System.out.println("numra = " + numra + " denomina " + denomina);
            System.out.println("Similarity = %.2d"  +  numra / denomina);
        }
    }
}