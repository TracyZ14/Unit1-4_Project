public class Encoder
{
    private String originalMessage;

    public Encoder(String originalMessage)
    {
        this.originalMessage = originalMessage.toUpperCase();
    }

    public String atbashEncoder()
    {
        String encryptedMessage = "";
        String[] originalLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] encryptedLetters = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
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
                encryptedMessage = encryptedMessage + letter;
            }
            else
            {
                encryptedMessage = encryptedMessage + encryptedLetters[arrayIndex];
            }
        }
        return encryptedMessage;
    }

    public String caesarCipherEncoder(int shift)
    {
        String encryptedMessage = "";
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
                encryptedMessage = encryptedMessage + letter;
            }
            else
            {
                int shiftedLetterIndex = (arrayIndex + shift) % 26;
                encryptedMessage = encryptedMessage + originalLetters[shiftedLetterIndex];
            }
        }
        return encryptedMessage;
    }

    public String morseCodeEncoder()
    {
        String encryptedMessage = "";
        String[] originalCharacters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", ",", "?", "\'", "!", "/", "(", ")", "&", ":", ";", "=", "+", "-", "_", "\"", "$", "@"};
        String[] encryptedCharacters = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", ".-.-.-", "--..--", "..--..", ".----.", "-.-.--", "-..-.", "-.--.", "-.--.-", ".-...", "---...", "-.-.-.", "-...-", ".-.-.", "-....-", "..--.-", ".-..-.", "...-..-", ".--.-."};
        for(int index = 0; index < originalMessage.length(); index++)
        {
            String character = originalMessage.substring(index, index + 1);
            int arrayIndex = 0;
            boolean isCharacter = false;
            for(int i = 0; i < 54; i++)
            {
                if(originalCharacters[i].equals(character))
                {
                    arrayIndex = i;
                    isCharacter = true;
                }
            }
            if(character.equals(" "))
            {
                encryptedMessage = encryptedMessage + "xx";
            }
            else if(isCharacter == false)
            {
                encryptedMessage = encryptedMessage + "x" + character;
            }
            else
            {
                if(index == 0) {
                    encryptedMessage = encryptedCharacters[arrayIndex];
                }
                else if(originalMessage.substring(index - 1, index).equals(" "))
                {
                    encryptedMessage = encryptedMessage + encryptedCharacters[arrayIndex];
                }
                else
                {
                    encryptedMessage = encryptedMessage + "x" + encryptedCharacters[arrayIndex];
                }
            }
        }
        return encryptedMessage;
    }
}