package api.in.reqrec;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class ApiTest {

    @Test
    public void RegisterPositive() {
        Map<String,String> data = new HashMap<String, String>();
        data.put("email","eve.holt@reqres.in");
        data.put("password","pistol");
                given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test
    public void RegisterNegative() {
        Map<String,String> data = new HashMap<String, String>();
        data.put("email","eve.holt@reqres.in");
        data.put("password","");
        Response newUser = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().all()
                .statusCode(400)
                .extract()
                .response();

        Assert.assertEquals(newUser.jsonPath().get("error"),"Missing password");
    }

    @Test
    public void AvatarUsers() {
        List<String> collectResult =
                (given()
                .contentType("application/json")
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response()
                ).jsonPath().getList("data.avatar");

        Assert.assertTrue(collectResult.stream().allMatch(x -> x.contains("/1281.jpg")));
    }
}
