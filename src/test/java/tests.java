
import static org.junit.Assert.assertTrue;
import static io.restassured.RestAssured.*;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import org.junit.experimental.theories.suppliers.TestedOn;


public class tests
{
    private String api_key;

    @Before
    public void setup(){
        baseURI = "https://api.nasa.gov";
        KeyReader keyReader = new KeyReader();
        api_key = keyReader.getApiKey();
        basePath = "/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key="+api_key;

    }

    @Test
    public void nasaRequestSuccessful(){
        given().when().get(baseURI+basePath).then().statusCode(200).body("photos[1].sol", equalTo(1000));

    }

    @Test
    public void makeSureThatNasaApiIsWorking() {
        given().when().get("https://api.nasa.gov/planetary/apod?api_key="+api_key).then().statusCode(200);
    }

}
