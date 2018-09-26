import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        String filePath = new Scanner(System.in).next();
        readFile(filePath);
    }

    public static void readFile(String filePath) {
        final String COUNTRY_REGEX="^.*,\"(.*?)\"$";
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                Pattern pattern = Pattern.compile(COUNTRY_REGEX);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    System.out.println(matcher.group(1));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
