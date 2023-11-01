public class Encoder
{
    private String originalMessage;
    private String[] lowerCaseLetters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private String[] upperCaseLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    // Substitutes each letter of the alphabet with another letter by shifting the whole alphabet forward by a certain number of letters
    public String caesarCipher(int shift)
    {
        String encryptedMessage = "";
        String originalCharacter = "";
        for(int i = 0; i == originalMessage.length(); i++)
        {
            if(i == originalMessage.length())
            {
                originalCharacter = originalMessage.substring(i);
            }
            else
            {
                originalCharacter = originalMessage.substring(i, i + 1);
            }

        }
        return encryptedMessage;
    }
}