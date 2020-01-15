import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 *
 * @author Alexander Scheibe
 * @version 1/3/2020
 */
public class Hurricane{
    public static void main(String args[]) throws IOException
     {
        File file = new File("hurricanedata.txt");
        File formatFile = new File("HurricaneDataFormated.txt");
        PrintWriter outFile = new PrintWriter(formatFile);
        Scanner inFileCount = new Scanner(file);
        Scanner inFileSet = new Scanner(file);
        Scanner in = new Scanner(System.in);
        
        int yearStart = 0;
        int yearEnd = 0;
        int arrayCount = 0;

        boolean checkRange = false;
        while(checkRange == false)
        {
            System.out.println("What year");
            
        }

        while(inFileCount.hasNextLine())
        {
            inFileCount.nextLine();
            arrayCount++;
        }

        int[] year = new int[arrayCount];
        String[] month = new String[arrayCount];
        int[] pressure = new int[arrayCount];
        int[] windSpeed = new int[arrayCount];
        String[] name = new String[arrayCount];

        for(int i = 0; inFileSet.hasNextLine();i++)
        {  
            year[i] = inFileSet.nextInt();
            month[i] = inFileSet.next();
            pressure[i] = inFileSet.nextInt();
            windSpeed[i] = inFileSet.nextInt();
            name[i] = inFileSet.next();
        }

        
        for(int i = 0; i < arrayCount; i++)
        {

         outFile.printf("%5s%5s%5d%5d%10s%n", year[i], month[i], pressure[i], windSpeed[i], name[i]);
        }

      outFile.close();
      in.close();
      inFileCount.close();
      inFileSet.close();
    }
}