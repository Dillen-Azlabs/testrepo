package sg.ihh.ms.fms.app;

import sg.ihh.ms.fms.app.configuration.EncryptConfig;

public class Console {

    public static void main(String[] args) {
        String password = "192.168.0.207";
        EncryptConfig config = new EncryptConfig();
        String encrypted = config.stringEncryptor().encrypt(password);
        System.out.println(encrypted);
    }
}
