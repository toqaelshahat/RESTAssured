import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

public class DataClass {
    @DataProvider(name = "myDataProvider")
    public static Object[][] dataprovider(){
        return new Object[][]{
                { "us", "90210", "Beverly Hills" },
                { "us", "12345", "Schenectady" },
                { "ca", "B2R", "Waverley"}
        };

    }

}
