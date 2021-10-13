package creational;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.IOException;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject BookObject;
    private JSONArray AuthorsArray;

    public JSONBookMetadataFormatter() throws IOException {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        BookObject = new JSONObject();
        AuthorsArray = new JSONArray();
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
     /* char ch='"';
        String c = ch+","+ch;
        String authors = String.join(c, b.getAuthors());
        String authors2 = "["+authors+"]"; */

        JSONObject ThisBook = new JSONObject();
        ThisBook.put("ISBN", b.getISBN());
        ThisBook.put("Title", b.getTitle());
        ThisBook.put("Publisher", b.getPublisher());

        JSONArray Authors = new JSONArray();
        for (String getAuthor : b.getAuthors()) {
            Authors.add(getAuthor);
        }
        ThisBook.put("Authors",Authors);

        AuthorsArray.add(ThisBook);
        BookObject.put("Books", AuthorsArray);
        return this;
    }

    @Override
    public String getMetadataString() {
        return BookObject.toJSONString();
    }
}
