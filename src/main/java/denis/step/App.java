package denis.step;

import com.google.inject.Guice;
import denis.step.db.DbDemo;
import denis.step.ioc.DbModule;
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
        boolean showJournal = args.length > 0 && "--journal".equals(args[0]);
        Guice.createInjector(new ServicesModule(), new DbModule())
                .getInstance(DbDemo.class)
                .run(showJournal);
    }
}
