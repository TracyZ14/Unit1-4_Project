public class History
{
    private String originalMessage;
    private String encryptionDecryption;
    private String cipherUsed;
    private String encryptedDecryptedMessage;

    public History(String originalMessage, String encryptionDecryption, String cipherUsed, String encryptedDecryptedMessage)
    {
        this.originalMessage = originalMessage;
        this.encryptionDecryption = encryptionDecryption;
        this.cipherUsed = cipherUsed;
        this.encryptedDecryptedMessage = encryptedDecryptedMessage;
    }
}