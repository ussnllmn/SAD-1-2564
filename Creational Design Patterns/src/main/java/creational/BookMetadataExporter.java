package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {
    public abstract void export(PrintStream stream);
    public abstract void add(Book b);
}

class CSVBookMetadataExporter extends BookMetadataExporter {
    CSVBookMetadataFormatter CSVFormatter = new CSVBookMetadataFormatter();
    CSVBookMetadataExporter() throws IOException {
    }

    @Override
    public void export(PrintStream stream) {
        stream.println("\n"+"----- CSV File -----"+"\n"+CSVFormatter.getMetadataString());
    }
    @Override
    public void add(Book b) {
        CSVFormatter.append(b);
    }
}

class JSONBookMetadataExporter extends BookMetadataExporter {
    BookMetadataFormatter JSONFormatter = new JSONBookMetadataFormatter();
    JSONBookMetadataExporter() throws IOException {
    }

    @Override
    public void export(PrintStream stream) {
        stream.println("----- Json File -----"+"\n"+JSONFormatter.getMetadataString()+"\n");
    }
    @Override
    public void add(Book b) {
        JSONFormatter.append(b);
    }
}
class XMLBookMetadataExporter extends BookMetadataExporter {
    BookMetadataFormatter XMLFormatter = new XMLBookMetadataFormatter();
    XMLBookMetadataExporter() throws ParserConfigurationException {
    }

    @Override
    public void export(PrintStream stream) {
        stream.println("----- XML File -----"+"\n"+XMLFormatter.getMetadataString());
    }
    @Override
    public void add(Book b) {
        XMLFormatter.append(b);
    }
}