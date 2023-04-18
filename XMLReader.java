import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class Main {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("employee.xml");

            // Create a DocumentBuilder and parse the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Normalize the document to remove any extraneous white space
            doc.getDocumentElement().normalize();

            // Check if the user has specified which fields to output
            if (args.length > 0) {
                // Loop through the specified fields and output their values
                for (String field : args) {
                    switch (field) {
                        case "id":
                            System.out.println("ID: " + doc.getElementsByTagName("id").item(0).getTextContent());
                            break;
                        case "name":
                            System.out.println("Name: " + doc.getElementsByTagName("name").item(0).getTextContent());
                            break;
                        case "postalZip":
                            System.out.println("Postal Zip: " + doc.getElementsByTagName("postalZip").item(0).getTextContent());
                            break;
                        case "region":
                            System.out.println("Region: " + doc.getElementsByTagName("region").item(0).getTextContent());
                            break;
                        case "country":
                            System.out.println("Country: " + doc.getElementsByTagName("country").item(0).getTextContent());
                            break;
                        case "address":
                            System.out.println("Address: " + doc.getElementsByTagName("address").item(0).getTextContent());
                            break;
                        case "list":
                            System.out.println("List: " + doc.getElementsByTagName("list").item(0).getTextContent());
                            break;
                        default:
                            System.out.println("Invalid field: " + field);
                    }
                }
            } else {
                // If no fields are specified, output all fields
                System.out.println("ID: " + doc.getElementsByTagName("id").item(0).getTextContent());
                System.out.println("Name: " + doc.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Postal Zip: " + doc.getElementsByTagName("postalZip").item(0).getTextContent());
                System.out.println("Region: " + doc.getElementsByTagName("region").item(0).getTextContent());
                System.out.println("Country: " + doc.getElementsByTagName("country").item(0).getTextContent());
                System.out.println("Address: " + doc.getElementsByTagName("address").item(0).getTextContent());
                System.out.println("List: " + doc.getElementsByTagName("list").item(0).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}