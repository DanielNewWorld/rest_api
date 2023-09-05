import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {

    @DataProvider(name = "BooksData")
    public Object[][] getData() {
        return new Object[][]{
                {"123", "456"}, {"789", "101112"}, {"131415", "161718"}
        };
    }

    @Test(dataProvider = "BooksData")
    public void addBook() {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().header("Content-Type", "application/json")
                .body(payload.Addbook("123", "456"))
                .when().post("/Library/Addbook.php")
                .then().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(response);
        String id = js.getString("ID");
        System.out.println("ID: " + id);
    }
}
