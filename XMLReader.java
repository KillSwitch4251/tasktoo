import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the path of the XML file: ");
            String filePath = scanner.nextLine();

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder xmlContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                xmlContent.append(line.trim());
            }
            reader.close();

            JSONObject jsonObj = new JSONObject(xmlContent.toString());

            System.out.println("Enter the field(s) you want to extract (comma-separated): ");
            String fieldsStr = scanner.nextLine();
            String[] fields = fieldsStr.split(",");

            JSONObject selectedFieldsObj = new JSONObject();
            for (String field : fields) {
                if (jsonObj.has(field.trim())) {
                    selectedFieldsObj.put(field.trim(), jsonObj.get(field.trim()));
                } else {
                    System.out.println("Field not found: " + field.trim());
                }
            }

            System.out.println(selectedFieldsObj.toString(4));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}