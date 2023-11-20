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
        // Repeatedly run the program until the user inputs 5.
        for (int i = 0; nextAction != 5; i = i)
        {
            // Repeatedly ask the user what they want the program to do next until they input one of the choices.
            while(nextAction == 0)
            {
                System.out.println("Enter");
                System.out.println("  [1] to encrypt message");
                System.out.println("  [2] to decrypt message");
                System.out.println("  [3] to see history of previous encrypted / decrypted messages");
                System.out.println("  [4] to see what each cipher does");
                System.out.println("  [5] to stop running this program (resets history)");
                System.out.print("Next action: ");
                String nextActionChoice = s.nextLine();
                if(nextActionChoice.equals("1"))
                {
                    nextAction = 1;
                }
                else if(nextActionChoice.equals("2"))
                {
                    nextAction = 2;
                }
                else if(nextActionChoice.equals("3"))
                {
                    nextAction = 3;
                }
                else if(nextActionChoice.equals("4"))
                {
                    nextAction = 4;
                }
                else if(nextActionChoice.equals("5"))
                {
                    nextAction = 5;
                }
                else
                {
                    System.out.println();
                    System.out.println("This is not one of the choices provided.");
                }
                System.out.println();
            }
            // Encrypts the user's message.
            if(nextAction == 1)
            {
                // Repeatedly ask the user what cipher they want to use until they input one of the choices.
                while(cipherNumber == 0)
                {
                    System.out.println("Enter");
                    System.out.println("  [1] for atbash");
                    System.out.println("  [2] for caesar cipher");
                    System.out.println("  [3] for morse code");
                    System.out.print("Cipher: ");
                    String cipherChoice = s.nextLine();
                    if(cipherChoice.equals("1"))
                    {
                        cipherNumber = 1;
                    }
                    else if(cipherChoice.equals("2"))
                    {
                        cipherNumber = 2;
                    }
                    else if(cipherChoice.equals("3"))
                    {
                        cipherNumber = 3;
                    }
                    else
                    {
                        System.out.println();
                        System.out.println("This is not one of the choices provided.");
                    }
                }
                System.out.println();
                // Asks the user for the message they want to encrypt.
                System.out.print("Enter the message you want to encrypt: ");
                String message = s.nextLine();
                Encoder originalMessage = new Encoder(message);
                System.out.println();
                // Encrypts the user's message and determine which cipher they used.
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
                // Prints the encrypted message.
                System.out.println("Encrypted message: " + changedMessage);
                // Add the information about this encryption to history.
                History newHistory = new History(message, "Encryption", cipher, changedMessage);
                programHistory.add(newHistory);
                cipherNumber = 0;
            }
            // Decrypts the user's message.
            if(nextAction == 2)
            {
                // Repeatedly asks the user what cipher they want to use until they input one of the choices.
                while(cipherNumber == 0)
                {
                    System.out.println("Enter");
                    System.out.println("  [1] for atbash");
                    System.out.println("  [2] for caesar cipher");
                    /*
                    System.out.println("  [3] for morse code");
                    */
                    System.out.print("Cipher: ");
                    String cipherChoice = s.nextLine();
                    if(cipherChoice.equals("1"))
                    {
                        cipherNumber = 1;
                    }
                    else if(cipherChoice.equals("2"))
                    {
                        cipherNumber = 2;
                    }
                    /*
                    else if(cipherChoice.equals("3"))
                    {
                        cipherNumber = 3;
                    }
                    */
                    else
                    {
                        System.out.println();
                        System.out.println("This is not one of the choices provided.");
                    }
                }
                System.out.println();
                // Asks the user for the message they want to decrypt.
                System.out.print("Enter the message you want to decrypt: ");
                String message = s.nextLine();
                Decoder originalMessage = new Decoder(message);
                System.out.println();
                // Decrypts the user's message and determine which cipher they used.
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
                /*
                if(cipherNumber == 3)
                {
                    changedMessage = originalMessage.morseCodeDecoder();
                    cipher = "Morse Code";
                }
                */
                // Prints the decrypted message.
                System.out.println("Decrypted message: " + changedMessage);
                // Add the information about this decryption to history.
                History newHistory = new History(message, "Decryption", cipher, changedMessage);
                programHistory.add(newHistory);
                cipherNumber = 0;
            }
            // Print the information about previous encryptions and decryptions.
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
            // Prints what each cipher does.
            if(nextAction == 4)
            {
                // Repeatedly ask the user for what cipher they want to learn more about until they input one of the choices.
                while(cipherNumber == 0)
                {
                    System.out.println("Enter");
                    System.out.println("  [1] for atbash");
                    System.out.println("  [2] for caesar cipher");
                    System.out.println("  [3] for morse code");
                    System.out.print("Cipher: ");
                    String cipherChoice = s.nextLine();
                    if(cipherChoice.equals("1"))
                    {
                        cipherNumber = 1;
                    }
                    else if(cipherChoice.equals("2"))
                    {
                        cipherNumber = 2;
                    }
                    else if(cipherChoice.equals("3"))
                    {
                        cipherNumber = 3;
                    }
                    else
                    {
                        System.out.println();
                        System.out.println("This is not one of the choices provided.");
                    }
                }
                System.out.println();
                // Introduces the ciphers.
                if(cipherNumber == 1)
                {
                    System.out.println("Atbash is a substitution cipher with a key that takes a letter and map it to its reverse.");
                    System.out.println("In this program, the letters after encryption or decryption will all be in uppercase, and the characters that are not letters will not be encrypted.");
                    System.out.println("Key:");
                    System.out.println("Original letter  : A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z");
                    System.out.println("Encrypted letter : Z, Y, X, W, V, U, T, S, R, Q, P, O, N, M, L, K, J, I, H, G, F, E, D, C, B, A");
                }
                if(cipherNumber == 2)
                {
                    System.out.println("Caesar cipher is a substitution cipher with a key that takes a letter and replace it with a letter that is shifted a fixed number down the alphabet.");
                    System.out.println("In this program, the letters after encryption or decryption will all be in uppercase, and the characters that are not letters will not be encrypted.");
                    System.out.println("Example of a key that has a shift of 3:");
                    System.out.println("Original letter  : A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z");
                    System.out.println("Encrypted letter : D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, A, B, C");
                }
                if(cipherNumber == 3)
                {
                    System.out.println("Morse code is a substitution cipher with a key that takes a character and replace it with a standardized sequence of two different signal durations, dits (dots) and dahs (dashes)");
                    System.out.println("In this program, the letters after decryption will all be in uppercase, each character will be separated by a lowercase x in the morse code, a space will be represented as two lowercase x in the morse code, and the characters that are not in the key will not be encrypted.");
                    System.out.println("Key:");
                    System.out.println("Original character  : A , B   , C   , D  , E, F   , G  , H   , I , J   , K  , L   , M , N , O  , P   , Q   , R  , S  , T, U  , V   , W  , X   , Y   , Z   , 1    , 2    , 3    , 4    , 5    , 6    , 7    , 8    , 9    , 0    , .     , ,     , ?     , \'     , !     , /    , (    , )     , &    , :     , ;     , =    , +    , -     , _     , \"     , $      , @");
                    System.out.println("Encrypted character : .-, -..., -.-., -.., ., ..-., --., ...., .., .---, -.-, .-.., --, -., ---, .--., --.-, .-., ..., -, ..-, ...-, .--, -..-, -.--, --.., .----, ..---, ...--, ....-, ....., -...., --..., ---.., ----., -----, .-.-.-, --..--, ..--.., .----., -.-.--, -..-., -.--., -.--.-, .-..., ---..., -.-.-., -...-, .-.-., -....-, ..--.-, .-..-., ...-..-, .--.-.");
                }
                cipherNumber = 0;
            }
            System.out.println();
            nextAction = 0;
        }
        // Stops running the program.
        System.out.println("This program has stopped running.");
        s.close();
    }
}