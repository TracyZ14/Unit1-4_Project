/**
 * The Decoder class represents decryption. A decryption has the original message.
 */
public class Decoder
{
    public String originalMessage;

    /**
     * Constructor for the Decoder class. This creates a new instance of a Decoder given the below parameter.
     * @param originalMessage represents the message before decryption.
     */
    public Decoder(String originalMessage)
    {
        this.originalMessage = originalMessage.toUpperCase();
    }

    /**
     * The atbashDecoder method for the Decoder class. This method will decrypt the message using the atbash cipher.
     * @return a String of the message after being decrypted using atbash.
     */
    public String atbashDecoder()
    {
        String decryptedMessage = "";
        String[] originalLetters = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
        String[] decryptedLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for(int index = 0; index < originalMessage.length(); index++)
        {
            String letter = originalMessage.substring(index, index + 1);
            int arrayIndex = 0;
            boolean isLetter = false;
            for(int i = 0; i < 26; i++)
            {
                if(originalLetters[i].equals(letter))
                {
                    arrayIndex = i;
                    isLetter = true;
                }
            }
            if(isLetter == false)
            {
                decryptedMessage = decryptedMessage + letter;
            }
            else
            {
                decryptedMessage = decryptedMessage + decryptedLetters[arrayIndex];
            }
        }
        return decryptedMessage;
    }

    /**
     * The caesarCipherDecoder method for the Decoder class. This method will decrypt the message using the caesar cipher given the number of shift.
     * @param shift an integer representing how many letters the alphabet should be shifted.
     * @return a String of the message after being decrypted using caesar cipher.
     */
    public String caesarCipherDecoder(int shift)
    {
        String decryptedMessage = "";
        String[] originalLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for(int index = 0; index < originalMessage.length(); index++)
        {
            String letter = originalMessage.substring(index, index + 1);
            int arrayIndex = 0;
            boolean isLetter = false;
            for(int i = 0; i < 26; i++)
            {
                if(originalLetters[i].equals(letter))
                {
                    arrayIndex = i;
                    isLetter = true;
                }
            }
            if(isLetter == false)
            {
                decryptedMessage = decryptedMessage + letter;
            }
            else
            {
                int shiftedLetterIndex = (arrayIndex - shift) % 26;
                while(shiftedLetterIndex <= 0)
                {
                    shiftedLetterIndex = (26 - Math.abs(shiftedLetterIndex)) % 26;
                }
                decryptedMessage = decryptedMessage + originalLetters[shiftedLetterIndex];
            }
        }
        return decryptedMessage;
    }

    // Does not work.
    /*
     /**
     * The morseCodeDecoder method for the Decoder class. This method will decrypt the message using morse code.
     * @return a String of the message after being decrypted using morse code.
     */
    /*
    public String morseCodeDecoder()
    {
        String decryptedMessage = "";
        String[] originalCharacters = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", ".-.-.-", "--..--", "..--..", ".----.", "-.-.--", "-..-.", "-.--.", "-.--.-", ".-...", "---...", "-.-.-.", "-...-", ".-.-.", "-....-", "..--.-", ".-..-.", "...-..-", ".--.-."};
        String[] decryptedCharacters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", ",", "?", "\'", "!", "/", "(", ")", "&", ":", ";", "=", "+", "-", "_", "\"", "$", "@"};
        int endIndex = 0;
        String morseCodeCharacter = "";
        for(int index = 0; index < originalMessage.length(); index = index)
        {
            String characterAfterX = "";
            if(originalMessage.indexOf("x") == index)
            {
                if(originalMessage.length() == (index + 1))
                {
                    characterAfterX = originalMessage.substring(index + 1);
                }
                else
                {
                    characterAfterX = originalMessage.substring(index + 1, index + 2);
                }
                if(characterAfterX.equals("x"))
                {
                    originalMessage = originalMessage.substring(index + 2);
                    decryptedMessage = decryptedMessage + " ";
                }
                else
                {
                    originalMessage = originalMessage.substring(index + 1);
                    decryptedMessage = decryptedMessage;
                }
            }
            else
            {
                if(originalMessage.contains("x"))
                {
                    endIndex = originalMessage.indexOf("x");
                    morseCodeCharacter = originalMessage.substring(0, endIndex);
                }
                else
                {
                    morseCodeCharacter = originalMessage;
                }
                int arrayIndex = 0;
                for (int i = 0; i < 54; i++)
                {
                    if (originalCharacters[i].equals(morseCodeCharacter))
                    {
                        arrayIndex = i;
                    }
                }
                decryptedMessage = decryptedMessage + decryptedCharacters[arrayIndex];
            }
        }
        return decryptedMessage;
    }
    */
}