import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBinary
{
    public static void main(String[] args)
    {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("numbers.dat"));

            double [] numbers = {10.2, 20, 5.1, 8, 9.9};

            for (double i : numbers)
            {
                dos.writeDouble(i);
            }

            dos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
