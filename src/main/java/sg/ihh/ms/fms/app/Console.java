package sg.ihh.ms.fms.app;

import sg.ihh.ms.fms.app.configuration.EncryptConfig;
import sg.ihh.ms.fms.app.manager.EncryptionManager;

public class Console {

    public static void main(String[] args) {
        // To encrypt database information that is enclosed with ENC(..)
        String password = "192.168.0.207";
        EncryptConfig config = new EncryptConfig();
        String encrypted = config.stringEncryptor().encrypt(password);
        System.out.println(encrypted);

        // To encrypt OAUTH2 client secret
        String password2 = "8dWZpcce6gRR2KOJ8dmIZp7WhYYLmtdWIf8Cp2oX";
        EncryptionManager em = EncryptionManager.getInstance();
        String encrypted2 = em.encrypt(password2);
        System.out.println(encrypted2);
        System.out.println(em.decrypt(encrypted2));  // double-check
    }
}
