package denis.step.ioc;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import denis.step.services.hash.HashService;
import denis.step.services.hash.Md5HashService;
import denis.step.services.hash.ShaHashService;
import denis.step.services.string.FileNameGenerator;
import denis.step.services.string.OtpGenerator;
import denis.step.services.string.PasswordGenerator;
import denis.step.services.string.SaltGenerator;
import denis.step.services.string.StringGenerator;
public class ServicesModule extends AbstractModule {
    @Override
    protected void configure() {
        bind( HashService.class )
                .annotatedWith( Names.named("digest") )
                .to( Md5HashService.class ) ;

        bind( HashService.class )
                .annotatedWith( Names.named("signature") )
                .to( ShaHashService.class ) ;
        bind( String.class )
                .annotatedWith( Names.named("appName") )
                .toInstance( "Java-PV221" );
        bind(StringGenerator.class)
                .annotatedWith(Names.named("fileNameGenerator"))
                .to(FileNameGenerator.class);

        bind(StringGenerator.class)
                .annotatedWith(Names.named("saltGenerator"))
                .to(SaltGenerator.class);

        bind(StringGenerator.class)
                .annotatedWith(Names.named("otpGenerator"))
                .to(OtpGenerator.class);

        bind(StringGenerator.class)
                .annotatedWith(Names.named("passwordGenerator"))
                .to(PasswordGenerator.class);

    }
}
