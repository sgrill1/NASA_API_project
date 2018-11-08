import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class NASAHTTPManager {
    private String baseURI;
    private String images;
    private String apiKey;

    public NASAHTTPManager(){
        KeyReader keyReader = new KeyReader();
        apiKey = "api_key=" + keyReader.getApiKey();
        baseURI = "https://api.nasa.gov/mars-photos/api/v1/rovers/";
    }

    public void setImages(){
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet requestImages = new HttpGet(baseURI + "curiosity/photos?sol=1000&" + apiKey);
            CloseableHttpResponse response = httpClient.execute(requestImages);
            images = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getImages() {
        return images;
    }
}
