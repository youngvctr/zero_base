import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {
        try{
            File file = new File("index1.html");

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write("<!doctype html>\r\n<html lang=\"ko\">\r\n");
            writer.write("<head>\r\n    <meta charset=\"UTF-8\"/>\r\n  <style>\r\n");
            writer.write("    table { border: 1px; border-collapse: collapse; width: 100%; text-align: left; }\r\n");
            writer.write("    th, td { border: 1px solid #000; }\r\n  </style>\r\n</head>\r\n");
            writer.write("<body>\r\n  <h1>&#51088;&#48148; &#54872;&#44221;&#51221;&#48372;</h1>\r\n  <table>\r\n");
            writer.write("    <tr>\r\n      <th align=center>&#53412;</th>\r\n      <th align=center>&#44050;</th>\r\n    </tr>\r\n");

            for(Object k : System.getProperties().keySet()){
                String key = (String) k ;
                String value = System.getProperty(key);
                writer.write("    <tr>\r\n      <th>" + key + "</th>\r\n");
                writer.write("      <th>" + value + "</th>\r\n    </tr>\r\n");
            }

            writer.write("  </table>\r\n</body>\r\n</html>\r\n");
            writer.flush();
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
