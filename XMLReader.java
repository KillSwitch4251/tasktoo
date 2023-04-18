import java.io.File;
import java.util.Scanner;
import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the path of the XML file: ");
            String filePath = scanner.nextLine();

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            System.out.println("Enter the field(s) you want to extract (comma-separated): ");
            String fieldsStr = scanner.nextLine();
            String[] fields = fieldsStr.split(",");

            JSONObject selectedFieldsObj = new JSONObject();
            DefaultHandler handler = new DefaultHandler() {
                private String currentField = "";
                private boolean isCurrentFieldSelected = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (containsField(fields, qName)) {
                        currentField = qName;
                        isCurrentFieldSelected = true;
                    } else {
                        isCurrentFieldSelected = false;
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    if (isCurrentFieldSelected) {
                        String fieldValue = new String(ch, start, length).trim();
                        if (!fieldValue.isEmpty()) {
                            selectedFieldsObj.put(currentField, fieldValue);
                        }
                    }
                }
            };

            saxParser.parse(new File(filePath), handler);

            System.out.println(selectedFieldsObj.toString(4));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static boolean containsField(String[] fields, String fieldName) {
        for (String field : fields) {
            if (field.trim().equals(fieldName)) {
                return true;
            }
        }
        return false;
    }
}