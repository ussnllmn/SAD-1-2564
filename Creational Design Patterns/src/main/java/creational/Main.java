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
        // ---- Edit file type to change type of file-----
        String Filetype = "CSV";
        BookMetadataExporter Exporter = new allBookMetadataExporter();
        Exporter.add(Filetype,TestData.dinosaurBook);
        Exporter.add(Filetype,TestData.dragonBook);
        Exporter.export(Filetype, System.out);
    }
}
