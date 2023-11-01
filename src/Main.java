import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter:");
        System.out.println("  '1' to encrypt message");
        System.out.println("  '2' to decrypt message");
        System.out.println("  '3' to see history of previous encrypted / decrypted messages");
        System.out.println("  '4' to stop running this program (resets history)");
        int nextAction = Integer.parseInt(s.nextLine());
        if(nextAction != 4)
        {
            while(nextAction != 4)
            {
                if(nextAction == 1)
                {

                }
                else if(nextAction == 2)
                {

                }
                else
                {

                }
                System.out.println("Enter:");
                System.out.println("  '1' to encrypt message");
                System.out.println("  '2' to decrypt message");
                System.out.println("  '3' to see history of previous encrypted / decrypted messages");
                System.out.println("  '4' to stop running this program (resets history)");
                nextAction = Integer.parseInt(s.nextLine());
            }
            System.out.println("This program has stopped running.");
        }
        else
        {
            System.out.println("This program has stopped running.");
        }
        s.close();
    }
}