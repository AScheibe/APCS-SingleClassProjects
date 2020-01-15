/**
 * Generates a number of random passwords based on a series of 
 * choices made by the user, utilizing the ASCII data table.
 * 
 *
 * @author Alexander Scheibe
 * @version 1/8/2020
 */
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
public class SecretPasscodes
{
    public static void main(String [ ] args) throws IOException
    {
        int selection = 0;
        int passwordLength = 0;
        int passNum = 0;
        String password = "";
        Random rand = new Random();
        File file = new File("passwords.txt");
        PrintWriter outFile = new PrintWriter(file);
        Scanner inFile = new Scanner(file);
        Scanner in = new Scanner(System.in);
    
        
        System.out.println("             Password Generator Menu");
        System.out.println("******************************************************");
        System.out.println("*  [1] Lowercase Letters                             *");
        System.out.println("*  [2] Lowercase And Uppercase Letters               *");
        System.out.println("*  [3] All Letters and Numbers                       *");
        System.out.println("*  [4] All Letters, Numbers, And Symbols             *");
        System.out.println("*  [5] Quit                                          *"); //Quit allows you to exit the program
        System.out.println("******************************************************");
        
        while(selection != 5)
        {
            System.out.print("Enter Selection (1-5): ");
            selection = in.nextInt();

            while(selection < 1 || selection > 5)
            {
                System.out.println("\tInvalid Option. Please try again.\n");
                System.out.print("Enter Selection (1-5): ");
                selection = in.nextInt();
            }
            
            if(selection != 5)
            {
                System.out.print("Password Length (6 or more): ");
                passwordLength = in.nextInt();
                
                while(passwordLength < 6)
                {
                    System.out.println("Invalid Option. Please try again.\n");
                    System.out.print("Password Length (6 or more): \n");
                    selection = in.nextInt();
                }
                
                for(int i = 0; i < passwordLength; i++) 
                {
                    if(selection == 1)
                    {
                        passNum = rand.nextInt(78) + 48;
                        while(passNum < 97 || passNum > 122)
                        {
                            passNum = rand.nextInt(78) + 48;
                        }
                    }
                    else if(selection == 2)
                    {
                        passNum = rand.nextInt(78) + 48;
                        while((passNum < 97 || passNum > 122) && (passNum < 65 || passNum > 90))
                        {
                            passNum = rand.nextInt(78) + 48;
                        }
                    }
                    else if(selection == 3)
                    {
                        passNum = rand.nextInt(78) + 48;
                        while((passNum < 97 || passNum > 122) && (passNum < 65 || passNum > 90) && (passNum > 57))
                        {
                            passNum = rand.nextInt(78) + 48;
                        }
                    }
                    else if(selection == 4)
                    {
                        passNum = rand.nextInt(78) + 48;
                    }
                    password += (char)passNum;
                }
                
                outFile.println(password);
                password = "";
                
            }
            else
            {
                outFile.close();
                if(inFile.hasNext())
                {
                    System.out.println("\nPasswords:");

                    int i = 1;
                    while(inFile.hasNext())
                    {
                        String pass = inFile.next();
                        System.out.println(" " + i + "\t" + pass);
                        i++;
                    }
                }
                inFile.close();    
                   
            }
        }   
    }
}
