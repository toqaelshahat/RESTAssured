

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class basetest {

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {

        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places[0].'place name'", equalTo("Beverly Hillss"));
    }
    @Test
    public void requestUsZipCode90210_checkStatusCode_expectHttp200() {

        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().contentType(ContentType.JSON);
    }
    @Test
    public void requestUsZipCode90210_checkStatusCode_expectHttp() {

        RestAssured.given().log().all().when().get("http://zippopotam.us/us/90210")
                .then().log().body();
    }
    @Test
    public void requestUsZipCode90210_checkcontent() {

        RestAssured
                .given()
                .when()
                .get("http://zippopotam.us/us/90210")
                .then()
                .assertThat()
                .body("places.'place name'", contains("Beverly Hills"));
    }
    @Test
    public void requestUsZipCode90210_checkhasitem() {

        RestAssured.given().log().all().when().get("http://zippopotam.us/us/90210")
                .then().log().body();
    }
    @Test
    public void requestUsZipCode90210_checksize() {

        RestAssured.given().log().all().when().get("http://zippopotam.us/us/90210")
                .then().log().body();
    }
    @Test(dataProviderClass = DataClass.class, dataProvider="myDataProvider")
    public void requestUsZipCode90210_dataProvider(String countryCode, String zipCode, String expectedPlaceName) {

        RestAssured.given().pathParam("countryCode", countryCode).pathParam("zipCode", zipCode)
                .when()
                .get("http://zippopotam.us/{countryCode}/{zipCode}")
                .then()
                .assertThat()
                .body("places[0].'place name'", equalTo(expectedPlaceName))
                .log().all();
    }


}
