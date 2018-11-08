import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RoverPhotosParser {
    private JSONObject imagesJSON;
    private JSONArray imagesResults;

    RoverPhotosParser() {
        NASAHTTPManager nasahttpManager = new NASAHTTPManager ();
        nasahttpManager.setImages ();
        JSONFactory jsonFactory = new JSONFactory ();
        jsonFactory.setPhotosJSON (nasahttpManager.getImages ());
        imagesJSON = jsonFactory.getPhotosJSON ();
        imagesResults = getResultsJSONObject();

    }
    private JSONArray getResultsJSONObject(){return (JSONArray) imagesJSON.get("photos");}

    public String getImageSource(){
        JSONObject singleImage = (JSONObject) imagesResults.get(20);
        return singleImage.get("img_src").toString ();
    }

    public String getEarthDate(){
        JSONObject singleEarthDate = (JSONObject) imagesResults.get(1);
        return singleEarthDate.get("earth_date").toString();
    }

    public int getTotalPhotos(){
        JSONObject singleImage = (JSONObject) imagesResults.get(0);
        JSONObject rover = (JSONObject) singleImage.get("rover");
        return Integer.parseInt(rover.get("total_photos").toString());
    }

    public String getStatus() {
        JSONObject singleImage = (JSONObject) imagesResults.get(0);
        JSONObject rover = (JSONObject) singleImage.get("rover");
        return rover.get("status").toString();
    }

    public String getRoverName(){
        JSONObject singleImage = (JSONObject) imagesResults.get(0);
        JSONObject rover = (JSONObject) singleImage.get("rover");
        return rover.get("name").toString();
    }
}
