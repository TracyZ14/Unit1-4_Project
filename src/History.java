/**
 * The History class represents previous encryptions and decryptions. A history has the original message, whether it was encrypted or decrypted, the cipher used, and the message after being encrypted or decrypted.
 */
public class History
{
    private String originalMessage;
    private String encryptionDecryption;
    private String cipherUsed;
    private String changedMessage;

    /**
     * Constructor for the History class. This creates a new instance of a History given the below parameters.
     * @param originalMessage represents the message before encryption or decryption.
     * @param encryptionDecryption represents whether the message was encrypted or decrypted.
     * @param cipherUsed represents the cipher used in the encryption or decryption.
     * @param changedMessage represents the message after it was encrypted or decrypted.
     */
    public History(String originalMessage, String encryptionDecryption, String cipherUsed, String changedMessage)
    {
        this.originalMessage = originalMessage;
        this.encryptionDecryption = encryptionDecryption;
        this.cipherUsed = cipherUsed;
        this.changedMessage = changedMessage;
    }

    /**
     * The getOriginalMessage method for the History class. This method will return only the originalMessage of the History object.
     * @return a String representing the original message before encryption or decryption.
     */
    public String getOriginalMessage()
    {
        return originalMessage;
    }

    /**
     * The getEncryptionDecryption method for the History class. This method will return only the encryptionDecryption of the History object.
     * @return a String representing the whether the message was encrypted or decrypted.
     */
    public String getEncryptionDecryption()
    {
        return encryptionDecryption;
    }

    /**
     * The getCipherUsed method for the History class. This method will return only the cipherUsed of the History object.
     * @return a String representing the cipher used in the encryption or decryption.
     */
    public String getCipherUsed()
    {
        return cipherUsed;
    }

    /**
     * The getChangedMessage method for the History class. This method will return only the changedMessage of the History object.
     * @return a String representing the message after it was encrypted or decrypted.
     */
    public String getChangedMessage()
    {
        return changedMessage;
    }
}