package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException {

     // Current usage
     /* BookMetadataFormatter formatter = null;
        try {
            formatter = BookMetadataFormatterFactory.getBookMetadataFormatter(BookMetadataFormatterFactory.Format.CSV);
            formatter.append(TestData.dragonBook);
            formatter.append(TestData.dinosaurBook);
            System.out.print(formatter.getMetadataString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
     */

     // Expected usage
     // ---- CSV File -----
        BookMetadataExporter csvExporter = new CSVBookMetadataExporter();
        csvExporter.add(TestData.dinosaurBook);
        csvExporter.add(TestData.dragonBook);
        csvExporter.export(System.out);

     // ---- JSON File -----
        BookMetadataExporter jsonExporter = new JSONBookMetadataExporter();
        jsonExporter.add(TestData.dinosaurBook);
        jsonExporter.add(TestData.dragonBook);
        jsonExporter.export(System.out);

     // ---- XML File -----
        BookMetadataExporter xmlExporter = new XMLBookMetadataExporter();
        xmlExporter.add(TestData.dinosaurBook);
        xmlExporter.add(TestData.dragonBook);
        xmlExporter.export(System.out);
    }
}
