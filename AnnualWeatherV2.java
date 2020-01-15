/**
 * Given a set of data, this program outputs annual temperature averages and rainfall totals
 * for a given city.
 * 
 * @author Alexander Scheibe
 * @version 11/10/20
 *
 */
import java.util.Scanner;
public class AnnualWeatherV2
{public static void main (String [ ] args)
    {

        //Declare and initialize variables
        Scanner in = new Scanner(System.in);
        String city = "Apalachicola";
        String state = "Fl";

        double tempComposite = 0;
        double precipComposite = 0;
        double tempAverage = 0;
        double precipAverage = 0;

        String [] month = {"Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
        
        double [] temperature ={52.7, 55.3, 60.7, 66.8,	74.1, 80.0, 81.9, 81.7, 79.1, 70.2,	62.0, 55.2};     
        //double [] temperature ={64.9, 66.0, 69.9, 73.6, 78.8, 82.2, 83.0, 83.1, 82.1, 77.5, 71.7, 66.4};
        double [] precipitation ={4.9, 3.8, 5.0, 3.0, 2.6, 4.3, 7.3, 7.3, 7.1, 4.2, 3.6, 3.5};      
        // double [] precipitation ={2.2, 2.1, 2.7, 1.7, 3.4, 9.8, 9.0, 9.5, 7.9, 2.6, 1.7, 1.6}; 

        System.out.println("What unit do you want the temperature to be displayed in (C/F)?");
        String tempLabel = in.nextLine();
        tempLabel = tempLabel.toUpperCase();

        System.out.println("What unit do you want the temperature to be displayed in (in/cm)?");
        String precipLabel = in.nextLine();
        precipLabel = precipLabel.toLowerCase();
    
        in.close();

        //Processing - calculate average temperature and total precipitation
        for(int i = 0; i < temperature.length; i++)
        {
            if(tempLabel.equals("C"))
            {
                temperature[i] = (temperature[i] - 32) * 5/9.0;
            }
            if(precipLabel.equals("cm"))
            {
                precipitation[i] = precipitation[i] * 2.54;
            }
            tempComposite += temperature[i];
            precipComposite += precipitation[i];  
        }
        
        tempAverage = tempComposite / 12;
        precipAverage = precipComposite / 12;
    
        //Output: display table of weather data including average and total
        System.out.println();
        System.out.println("                 Weather Data");
        System.out.printf("          Location: %s, %s%n", city, state);
        System.out.printf("Month     Temperature (%s)    Precipitation (%s)", tempLabel, precipLabel);
        System.out.println();
        System.out.println("***************************************************");

        for( int i = 0; i < temperature.length; i++)
        {
            System.out.printf("%-5s%16.1f%20.1f%n", month[i], temperature[i], precipitation[i]);
        }
        System.out.println("***************************************************\n");
        System.out.printf("Average Temperature: %2.1f%2s    Total Precipitation: %2.1f%3s", tempAverage, tempLabel, precipComposite, precipLabel);

    }//end main
}//end class