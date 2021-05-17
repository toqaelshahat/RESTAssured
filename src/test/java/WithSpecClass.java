import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class WithSpecClass {
    private static RequestSpecification specification;
    private static ResponseSpecification responseSpec;
    @BeforeClass
    public static void createRequestSpecification(){
        specification = new RequestSpecBuilder()
                .setBaseUri("http://api.zippopotam.us").build();
        responseSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();


    }
    @Test
    public void createRequestSpecificationmethod(){
        String placeName =RestAssured.given().spec(specification)
                .when()
                .get("us/90210")
                .then()
                .spec(responseSpec)
                .and()
                .extract()
                .path("places[0].'place name'");
        Assert.assertEquals(placeName, "Beverly Hills");
    }



}
