// -------------------> Warning
import java.nio.file.*;
import java.nio.file.Paths;
import java.io.*;
import java.nio.*;

// -------------------> Warning

class FileManager {
    private Path currentDirecory;
    FileManager(String initialePath)
    {
        currentDirecory = Paths.get(initialePath);
    }
    public Path getPath()
    {
        return currentDirecory;
    }

    public void listFiles()
    {
        File[] files = currentDirecory.toFile().listFiles();
        for (File file:files)
        {
            if (file != null)
                System.out.println(file.getName() + " " + file.length() / 1000 + " KB");
        }
    }

    public void cdCommand(String nextDirectory)
    {
        // resolve(folderName):
        //This method appends the specified path (folderName) to the existing path

        //normalize():
        //This method removes any redundant elements from the path, such as . (current directory) or .. (parent directory).

        Path newPath = currentDirecory.resolve(nextDirectory).normalize();
        if (Files.isDirectory(newPath))
        {
            System.out.println(newPath.toString());
            currentDirecory = newPath;
        }
        else
            System.out.println("No Directory Found with this name : " + nextDirectory);
    }

    public void mvCommand(String current,String nextOne)
    {
        Path what = currentDirecory.resolve(current).normalize();
        Path targetPath = currentDirecory.resolve(nextOne).normalize();
        // If targetPath Is a Directory so its gonna be moving function
        if (Files.isDirectory(targetPath))
        {
            Path fullNewPath = targetPath.resolve(what.getFileName());
            try{
                System.out.println(fullNewPath.toString() + " \n" + what.toString());
                Files.move(what,fullNewPath);
            }catch(IOException e)
            {    
                System.out.println(e.getMessage());
                System.out.println("Failed to move the file");
            }
        }
        else
        {
            try{
                System.out.println(targetPath.toString() + " \n" + what.toString());
                Files.move(what,targetPath,StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e)
            {    
                System.out.println(e.getMessage());
                System.out.println("Failed to move the file");
            }
        }
    }



    public void commandHandler(String command)
    {
        String[] sp = command.split(" ");
        switch(sp[0])
        {
            case "ls" :
                listFiles();
                break;
            case "cd":
                if (sp.length == 2)
                    cdCommand(sp[1]);
                else
                    System.out.println("Sorry for that but this is not bash command line ;)");
                break;
            case "mv":
                if (sp.length == 3)
                    mvCommand(sp[1],sp[2]);
                else
                    System.out.println("Sorry for that but this is not bash command line ;)");
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Command Not found.");
        }
    }


}