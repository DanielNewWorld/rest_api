import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Basics2 {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(payload.AddPlace()).when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("server","Server: Apache/2.4.41 (Ubuntu)");
    }
}

//"place_id": "e03402ca620000ee4ace6f157aa445d3",
//        "scope": "APP",
//        "reference": "1df596eb63812d21ea1c7963be4091561df596eb63812d21ea1c7963be409156",
//        "id": "1df596eb63812d21ea1c7963be409156"
