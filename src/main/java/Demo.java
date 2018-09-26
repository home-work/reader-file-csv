import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        String filePath = new Scanner(System.in).next();
        readFile(filePath);
    }

    public static void readFile(String filePath) {
        final String COUNTRY_REGEX="^\\s$";
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\"", "");
                String[] lines = line.split(".*,[A-Z]{2},");
                for (String s : lines) {
                    if (s.length() != 0) {
                        System.out.println(s);
                    }
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
