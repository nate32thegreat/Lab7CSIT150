/********************************************************************
 ReadBinary.java
 Author: Nate Kiolbasa
 Date: 3/7/18

 Program Description:

 Allows user to read a binary file chosen "doubles.dat",
 and the text file chosen "doubles.csv".

 Algorithm:

 1. Implement starting code provided by the class lecture on 3/5/18
 2. In the main method, read the binary file a first time to see how many data members are in it
 3. Use exception handling when reading the binary file
 4. Then open the binary file again and read out the calculated average and data members
 5. BONUS: Use the same steps for reading the binary code except use the text file
 6. Display results
 7. End program

 Citation:

 Starting code was provided by Dr. Harms

 *NOTE*

 Starting Code was not provided on Canvas before I finished the lab,
 hence some syntax may be different from the Canvas code.

 ********************************************************************/

import java.io.*;
import java.util.Scanner;

public class ReadBinary
{
    /**
     * This method reads a text file given
     * and uses exception handling to return the values from it
     * @param file, r
     */
    public static String displayCsv (File file, Scanner scan)
    {
        try
        {
            scan = new Scanner(file);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        String display = "";
        String [] values;
        String numbers;
        double average = 0;
        double sum = 0;

        numbers = scan.nextLine();

        values = numbers.split(",");

        double [] valuesCon = new double[values.length];

        for (int i = 0; i < values.length; i++)
        {
            valuesCon[i] = Double.parseDouble(values[i]);
        }

        for (int i = 0; i < values.length; i ++)
        {
            sum += valuesCon[i];
            average = (sum / values.length);
        }

        System.out.println("Values and average from a text file:\n");

        display = "The values from the file are: \n";

        for (int i = 0; i < values.length; i++)
        {
            display += values[i] + " ";
        }
        display += "\n\nThe average of the file is: " + String.format("%.2f",average);

        return display;

    }
    /**
     * The main method reads in the binary file
     * and uses exception handling to return the values from it
     * It also prints off the results from the displayCsv method
     */
    public static void main(String[] args)
    {
        System.out.println("Allows user to read a binary file chosen \"doubles.dat\","
                + " and the text file chosen \"doubles.csv\".\n\n"
                + "Please note that the file entered must be on \n"
                + "the local system as \"doubles.dat\" and \"doubles.csv\"\n");

        Scanner scan = new Scanner(System.in);

        File inputFile = new File("doubles.csv");

        String name = displayCsv(inputFile, scan);

        System.out.println(name);

        double [] numbers = null;
        boolean endOfFile = false;
        int count = 0;

        try
        {
            DataInputStream dis = new DataInputStream(new FileInputStream("doubles.dat"));

            while (!endOfFile)
            {
                try
                {
                    dis.readDouble();
                    count++;
                }
                catch (EOFException e)
                {
                    endOfFile = true;
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            dis.close();

            dis = new DataInputStream(new FileInputStream("doubles.dat"));

            numbers = new double[count];

            System.out.println("\nValues and average from a binary file: ");

            for (int i = 0; i < numbers.length; i++)
            {
                numbers[i] = dis.readDouble();
            }
            dis.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        for (double i : numbers)
        {
            System.out.print(i + " ");
        }

        double average = 0;
        double sum = 0;

        for (int i = 0; i < numbers.length; i ++)
        {
            sum += numbers[i];
            average = (sum / numbers.length);
        }
        
        System.out.printf("\n\nThe average of the numbers is: %.2f\n", average);
    }
}
