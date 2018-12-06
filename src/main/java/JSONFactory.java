import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFactory {
    private JSONObject photosJSON;

    public JSONObject getPhotosJSON() {
        return photosJSON;
    }

    public void setPhotosJSON(String photos) {
        JSONParser jsonParser = new JSONParser();
        try {
            photosJSON = (JSONObject) jsonParser.parse(photos);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
