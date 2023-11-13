public class Decoder
{
    public String originalMessage;

    public Decoder(String originalMessage)
    {
        this.originalMessage = originalMessage.toUpperCase();
    }

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

    public String caesarCipherDecoder(int shift)
    {
        String decryptedMessage = "";
        String[] originalLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for(int index = 0; index < originalMessage.length(); index++)
        {
            String letter = originalMessage.substring(index, index + 1);
            int arrayIndex = 0;
            boolean isLetter = false;
            for(int i = 0; i < 25; i++)
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
                int shiftedLetterIndex = 26 - Math.abs((arrayIndex - shift) % 26);
                decryptedMessage = decryptedMessage + originalLetters[shiftedLetterIndex];
            }
        }
        return decryptedMessage;
    }

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
                if(originalMessage.length() > (index + 1))
                {
                    characterAfterX = originalMessage.substring(index + 1,index + 2);
                }
                if(characterAfterX.equals("x"))
                {
                    originalMessage = originalMessage.substring(index + 2);
                    decryptedMessage = decryptedMessage + " ";
                }
                if(!characterAfterX.equals("x"))
                {
                    originalMessage = originalMessage.substring(index + 2);
                    decryptedMessage = decryptedMessage + " ";
                }
            }
            else
            {
                if(originalMessage.contains("x"))
                {
                    endIndex = originalMessage.indexOf("x");
                    morseCodeCharacter = originalMessage.substring(index, endIndex);
                }
                else
                {
                    morseCodeCharacter = originalMessage.substring(index);
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
}