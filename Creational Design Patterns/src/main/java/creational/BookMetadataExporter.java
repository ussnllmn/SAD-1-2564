package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {
    public abstract void export(String Filetype,PrintStream stream);
    public abstract void add(String Filetype,Book b);
}

class allBookMetadataExporter extends BookMetadataExporter {
    CSVBookMetadataFormatter CSVFormatter = new CSVBookMetadataFormatter();
    JSONBookMetadataFormatter JSONFormatter = new JSONBookMetadataFormatter();
    XMLBookMetadataFormatter XMLFormatter = new XMLBookMetadataFormatter();
    allBookMetadataExporter() throws IOException, ParserConfigurationException {
    }

    @Override
    public void export(String Filetype, PrintStream stream) {
        switch (Filetype) {
            case "CSV":
                stream.println("----- CSV File -----" + "\n" + CSVFormatter.getMetadataString());
                break;
            case "JSON":
                stream.println("----- Json File -----"+"\n"+JSONFormatter.getMetadataString());
                break;
            case "XML":
                stream.println("----- XML File -----"+"\n"+XMLFormatter.getMetadataString());
                break;
        }
    }

    @Override
    public void add(String Filetype,Book b) {
        switch (Filetype) {
            case "CSV":
                CSVFormatter.append(b);
                break;
            case "JSON":
                JSONFormatter.append(b);
                break;
            case "XML":
                XMLFormatter.append(b);
                break;
        }
    }
}
