public class History
{
    private String originalMessage;
    private String encryptionDecryption;
    private String cipherUsed;
    private String changedMessage;

    public History(String originalMessage, String encryptionDecryption, String cipherUsed, String changedMessage)
    {
        this.originalMessage = originalMessage;
        this.encryptionDecryption = encryptionDecryption;
        this.cipherUsed = cipherUsed;
        this.changedMessage = changedMessage;
    }

    public String getOriginalMessage()
    {
        return originalMessage;
    }

    public String getEncryptionDecryption()
    {
        return encryptionDecryption;
    }

    public String getCipherUsed()
    {
        return cipherUsed;
    }

    public String getChangedMessage()
    {
        return changedMessage;
    }
}