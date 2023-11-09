import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nextAction = 0;
        for (int i = 0; nextAction != 4; i = i + 0)
        {
            System.out.println("Enter:");
            System.out.println("  '1' to encrypt message");
            System.out.println("  '2' to decrypt message");
            System.out.println("  '3' to see history of previous encrypted / decrypted messages");
            System.out.println("  '4' to stop running this program (resets history)");
            nextAction = Integer.parseInt(s.nextLine());
            if(nextAction == 1)
            {

            }
            if(nextAction == 2)
            {

            }
            if(nextAction == 3)
            {

            }
        }
        System.out.println("This program has stopped running.");
        s.close();
    }
}