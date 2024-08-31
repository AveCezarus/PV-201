package denis.step.services.string;

import java.security.SecureRandom;
import java.util.Base64;

public class SaltGenerator implements StringGenerator {
    private static final int LENGTH = 16;

    @Override
    public String generate() {
        byte[] salt = new byte[LENGTH];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}