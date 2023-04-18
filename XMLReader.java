import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class XMLReader {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("employee.xml");

            // Create a DocumentBuilder and parse the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Normalize the document to remove any extraneous white space
            doc.getDocumentElement().normalize();

            // Get the fields from the XML document
            String id = doc.getElementsByTagName("id").item(0).getTextContent();
            String name = doc.getElementsByTagName("name").item(0).getTextContent();
            String postalZip = doc.getElementsByTagName("postalZip").item(0).getTextContent();
            String region = doc.getElementsByTagName("region").item(0).getTextContent();
            String country = doc.getElementsByTagName("country").item(0).getTextContent();
            String address = doc.getElementsByTagName("address").item(0).getTextContent();
            String list = doc.getElementsByTagName("list").item(0).getTextContent();

            // Print out the field values
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Postal Zip: " + postalZip);
            System.out.println("Region: " + region);
            System.out.println("Country: " + country);
            System.out.println("Address: " + address);
            System.out.println("List: " + list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}