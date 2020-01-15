import java.util.*;
import java.io.*;
/**
 * Tests how many squirells are observed before you see a fox squirrel 
 *
 * @author Alexander Scheibe
 * @version 1/3/2020
 */
public class AnimalPopulation
{


 public static void main (String[ ] args) throws IOException
 {
    int numTests = 0;
    int totalNumSightings = 0;
    double averageNumSightings = 0;
    File file = new File("population.txt");
    PrintWriter outFile = new PrintWriter(file);
    Scanner inFile = new Scanner(file);
    Scanner in = new Scanner(System.in);
    Random rand = new Random();

    while(numTests < 1000){
        System.out.println("How many tests do you want to run?");
        numTests = in.nextInt();
        in.close();
    }

    System.out.println("Simulating...");

    for(int i = 1; i <= numTests; i++)
    {
        int numBeforeSights = 0;
        boolean testFox = false;
        while(testFox == false)
        {
            int getRand = rand.nextInt(10) + 1; 

            if(getRand == 1) //I did this in order to simulate the 10% cahnce of sight. Not sure if this is the way you wanted it, but it works.
            {
                testFox = true;
            }
            numBeforeSights++;
        }
        outFile.println(numBeforeSights);
    }
    outFile.close();
    
    while(inFile.hasNextLine())
    {
        String intString = inFile.nextLine();
        int parseInt = Integer.parseInt(intString);
        totalNumSightings += parseInt;
    }

    averageNumSightings = (double)(totalNumSightings) / (double)(numTests);
    averageNumSightings = ((int)(averageNumSightings * 10) / 10.0);
    System.out.println("Average number of sightings before wanted sighting: ");
    System.out.println(averageNumSightings);

 }
 
}
