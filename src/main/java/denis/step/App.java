package denis.step;

import com.google.inject.Guice;
import denis.step.async.AsyncDemo;
import denis.step.db.DbDemo;
import denis.step.db.IniFileWriter;
import denis.step.ioc.DbModule;
import denis.step.ioc.ServicesModule;
import com.google.inject.Injector;
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
//        boolean showJournal = args.length > 0 && "--journal".equals(args[0]);
//        Injector injector = Guice.createInjector(new ServicesModule(), new DbModule());
//        DbDemo dbDemo = injector.getInstance(DbDemo.class);
//        dbDemo.run(showJournal);
        Guice.createInjector(new ServicesModule(), new DbModule()).getInstance(AsyncDemo.class).run();


    }
}

