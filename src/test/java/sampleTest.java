import org.testng.Assert;
import org.testng.annotations.Test;

public class sampleTest {
    @Test(retryAnalyzer = retryLogic.class)
    public void test1(){
        boolean result = false;
        Assert.assertTrue(false);
    }

    @Test(retryAnalyzer = retryLogic.class)
    public void test2(){
        Assert.assertFalse(true);
    }
}
