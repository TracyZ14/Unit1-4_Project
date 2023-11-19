import java.util.Scanner;
import java.util.ArrayList;
public class EncoderDecoderRunner
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("This program is designed to allow the user to choose different ciphers to encrypt and decrypt their messages.");
        System.out.println();
        int nextAction = 0;
        String changedMessage = "";
        int cipherNumber = 0;
        String cipher = "";
        ArrayList<History> programHistory = new ArrayList<History>();
        for (int i = 0; nextAction != 4; i = i)
        {
            System.out.println("Enter");
            System.out.println("  [1] to encrypt message");
            System.out.println("  [2] to decrypt message");
            System.out.println("  [3] to see history of previous encrypted / decrypted messages");
            System.out.println("  [4] to stop running this program (resets history)");
            nextAction = Integer.parseInt(s.nextLine());
            if(nextAction == 1)
            {
                System.out.println("Enter");
                System.out.println("  [1] for atbash");
                System.out.println("  [2] for caesar cipher");
                System.out.println("  [3] for morse code");
                cipherNumber = Integer.parseInt(s.nextLine());
                System.out.println();
                System.out.print("Enter the message you want to encrypt: ");
                String message = s.nextLine();
                Encoder originalMessage = new Encoder(message);
                System.out.println();
                if(cipherNumber == 1)
                {
                    changedMessage = originalMessage.atbashEncoder();
                    cipher = "Atbash";
                }
                if(cipherNumber == 2)
                {
                    System.out.print("Enter the number of letters you want to shift by: ");
                    int shift = Integer.parseInt(s.nextLine());
                    changedMessage = originalMessage.caesarCipherEncoder(shift);
                    cipher = "Caesar Cipher";
                }
                if(cipherNumber == 3)
                {
                    changedMessage = originalMessage.morseCodeEncoder();
                    cipher = "Morse Code";
                }
                System.out.println("Encrypted message: " + changedMessage);
                History newHistory = new History(message, "Encryption", cipher, changedMessage);
                programHistory.add(newHistory);
            }
            if(nextAction == 2)
            {
                System.out.println("Enter");
                System.out.println("  [1] for atbash");
                System.out.println("  [2] for caesar cipher");
                cipherNumber = Integer.parseInt(s.nextLine());
                System.out.println();
                System.out.print("Enter the message you want to decrypt: ");
                String message = s.nextLine();
                Decoder originalMessage = new Decoder(message);
                System.out.println();
                if(cipherNumber == 1)
                {
                    changedMessage = originalMessage.atbashDecoder();
                    cipher = "Atbash";
                }
                if(cipherNumber == 2)
                {
                    System.out.print("Enter the number of letters you want to shift by: ");
                    int shift = Integer.parseInt(s.nextLine());
                    changedMessage = originalMessage.caesarCipherDecoder(shift);
                    cipher = "Caesar Cipher";
                }
                System.out.println("Decrypted message: " + changedMessage);
                History newHistory = new History(message, "Decryption", cipher, changedMessage);
                programHistory.add(newHistory);
            }
            if(nextAction == 3)
            {
                for(int historyIndex = 0; historyIndex < programHistory.size(); historyIndex++)
                {
                    History historyEntry = programHistory.get(historyIndex);
                    System.out.println("History " + (historyIndex + 1));
                    System.out.println("Original message                      : " + historyEntry.getOriginalMessage());
                    System.out.println("Encryption / decryption used          : " + historyEntry.getEncryptionDecryption());
                    System.out.println("Cipher used                           : " + historyEntry.getCipherUsed());
                    System.out.println("Message after encryption / decryption : " + historyEntry.getChangedMessage());
                    System.out.println();
                }
            }
        }
        System.out.println("This program has stopped running.");
        s.close();
    }
}