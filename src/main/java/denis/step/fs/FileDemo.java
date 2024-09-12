package denis.step.fs;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.HashMap;

public class FileDemo {
    public void run() {
        try( InputStream rs = this
         .getClass().getClassLoader().getResourceAsStream("db.ini"))
        {

           String content = readStream( rs );
           Map<String, String> ini = new HashMap<>();

           String[] lines = content.split("\n");
           for(String line : lines) {
               String[] parts = line.split("=");
                ini.put( parts[0].trim(), parts[1].trim() );
            }
           System.out.println(
                   String.format( "jdbc:%s://%s:%s/%s",
                           ini.get("dbms"),
                           ini.get("host"),
                           ini.get("port"),
                           ini.get("schema")
                   )
           );
        }
        catch (IOException ex) {
            System.err.println( ex.getMessage() );
        }
    }
    public void runFile(){
        System.out.println("File System");
        File file = new File("test.txt");
        try(InputStream is = new FileInputStream(file)){

            System.out.println(readStream(is));

        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private String readStream(InputStream in, Charset charset) throws IOException {
        byte[] buffer = new byte[4096];
        try(
                ByteArrayOutputStream byteBuilder = new ByteArrayOutputStream();
                BufferedInputStream bis = new BufferedInputStream(in)
        ) {
            int len;
            while ((len = bis.read(buffer)) != -1) {
                byteBuilder.write(buffer, 0, len);
            }
            return byteBuilder.toString( charset.name() );
        }
    }

    private String readStream(InputStream in) throws IOException {
        return readStream( in, StandardCharsets.UTF_8 );
    }
}
