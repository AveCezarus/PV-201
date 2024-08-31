package denis.step.services.string;
import java.security.SecureRandom;
public class OtpGenerator implements StringGenerator {
    private static final int LENGTH = 6;

    @Override
    public String generate() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}