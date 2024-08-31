package denis.step;

import com.google.inject.Guice;
import denis.step.ioc.IocDemo;
import denis.step.ioc.ServicesModule;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        //new Shop().Run();
        //new IocDemo(new Md5HashService()).run();
        Guice.createInjector(new ServicesModule()).getInstance(IocDemo.class).run();
    }
}
