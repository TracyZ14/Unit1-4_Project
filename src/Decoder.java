public class Decoder
{
    public String originalMessage;

    public Decoder(String originalMessage)
    {
        this.originalMessage = originalMessage;
    }

    public String atbashDecoder()
    {
        String decryptedMessage = "";
        String[] originalLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] decryptedLetters = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
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
}