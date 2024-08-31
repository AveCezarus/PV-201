package denis.step.ioc;


import com.google.inject.Inject;
import com.google.inject.name.Named;
import denis.step.services.hash.HashService;
import denis.step.services.string.StringGenerator;

import java.util.logging.Logger;
public class IocDemo {
    private final HashService digestHashService;
    private final HashService signatureHashService;
    private final String appName;
    private final StringGenerator fileNameGenerator;
    private final StringGenerator saltGenerator;
    private final StringGenerator otpGenerator;
    private final StringGenerator passwordGenerator;
    @Inject private Logger logger;

    @Inject
    public IocDemo(
            @Named("digest") HashService digestHashService,
            @Named("signature") HashService signatureHashService,
            @Named("appName") String appName,
            @Named("fileNameGenerator") StringGenerator fileNameGenerator,
            @Named("saltGenerator") StringGenerator saltGenerator,
            @Named("otpGenerator") StringGenerator otpGenerator,
            @Named("passwordGenerator") StringGenerator passwordGenerator
    ) {
        this.digestHashService = digestHashService;
        this.signatureHashService = signatureHashService;
        this.appName = appName;
        this.fileNameGenerator = fileNameGenerator;
        this.saltGenerator = saltGenerator;
        this.otpGenerator = otpGenerator;
        this.passwordGenerator = passwordGenerator;
    }


    public void run() {
        System.out.println( appName );
        System.out.println( digestHashService.digest( "123" ) );
        System.out.println( signatureHashService.digest( "123" ) );
        logger.info( appName );
        System.out.println("File Name: " + fileNameGenerator.generate());
        System.out.println("Salt: " + saltGenerator.generate());
        System.out.println("OTP: " + otpGenerator.generate());
        System.out.println("Password: " + passwordGenerator.generate());
    }
}