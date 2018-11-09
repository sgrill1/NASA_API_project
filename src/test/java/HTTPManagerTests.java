import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HTTPManagerTests {

    NASAHTTPManager nasahttpManager;

    @Before
    public void setup(){
        nasahttpManager = new NASAHTTPManager();
        nasahttpManager.setImages();
    }

    @Test
    public void getImageTest(){
        Assert.assertTrue(nasahttpManager.getImages() instanceof String);
    }

    @Test
    public void ManagerTypeTest(){
        Assert.assertTrue(nasahttpManager instanceof NASAHTTPManager);
    }
}
