import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    //@Test
    public void TestStatusCode() {
        given().get("http://services.groupkt.com/country/get/all").then().statusCode(200);
    }

    //@Test
    public void TestAllLogs() {
        given().get("http://services.groupkt.com/country/get/all").then().body("RestResponse.result.name", hasItems("India", "Afghanistan"));
    }

    //@Test
    public void TestWithHeaderAndParam() {
        given().header("", "").param("", "").when().get("http://services.groupkt.com/country/get/all").then().statusCode(400);
    }

    //@Test
    public void TestRoot() {
        given().get("http://services.groupkt.com/country/get/all").then().root("RestResponse.result").body("name", hasItems("India", "Afghanistan"));
    }

    //@Test
    public void TestDetachRoot() {
        given().get("http://services.groupkt.com/country/get/all").then().root("RestResponse.result").body("name", hasItems("India", "Afghanistan")).detachRoot("result").body("result.name", hasItem("India"));
    }

}
