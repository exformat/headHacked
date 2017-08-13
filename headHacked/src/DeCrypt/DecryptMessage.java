package DeCrypt;

/**
 * Created by Exformat on 31.07.17.
 */
class DecryptMessage {
    private static String endCryptMessage;

    public static String getEndCryptMessage() {
        return endCryptMessage;
    }

    static void setEndCryptMessage(String endCryptMessage) {
        DecryptMessage.endCryptMessage = endCryptMessage;
    }
}
