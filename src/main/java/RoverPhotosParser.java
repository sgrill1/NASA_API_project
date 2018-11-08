import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RoverPhotosParser {
    JSONObject imagesJSON;
    JSONArray imagesResults;

    RoverPhotosParser() {
        NASAHTTPManager nasahttpManager = new NASAHTTPManager ();
        nasahttpManager.setImages ();
        JSONFactory jsonFactory = new JSONFactory ();
        jsonFactory.setPhotosJSON (nasahttpManager.getImages ());
        imagesJSON = jsonFactory.getPhotosJSON ();
        imagesResults = getResultsJSONObject();

    }
    public JSONArray getResultsJSONObject(){return (JSONArray) imagesJSON.get("photos");}
    public String getImageSource(){
        JSONObject singleImage = (JSONObject) imagesResults.get(20);
        return singleImage.get("img_src").toString ();
    }

    public String getEarthDate(){
        JSONObject singleEarthDate = (JSONObject) imagesResults.get(1);
        return singleEarthDate.get("earth_date").toString();

    }
}
