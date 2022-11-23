package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ExtraTests {

    // Should not succeed and return 404 bc i can't give things as parameter
    @Test
    public void testAddNewextraWrongWay() {
        given().contentType(ContentType.JSON)
            .when().post("http://localhost:8080/extra/Maus/25.50/2")
            .then()
            .statusCode(404);
    }

    // Should not succeed and return 401 bc the User has no rights
    @Test
    public void testAddNewExtra() {
        given().contentType(ContentType.JSON)
        .body("{\"name\":\"KA\",\"price\":\"25.50\",\"place_id\":{\"id\":1}}")
            .when().post("http://localhost:8080/extra/")
            .then()
            .statusCode(401);
    }

    // Should succeed and return 200 bc the Mitglied has rights to add new extras
    @Test
    public void testAddNewExtraAsMitglied() {
        given().contentType(ContentType.JSON)
        .header("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3psaS5leGFtcGxlLmNvbS8iLCJ1cG4iOiJqZG9lQHF1YXJrdXMuaW8iLCJncm91cHMiOlsiTWl0Z2xpZWQiXSwiYmlydGhkYXRlIjoiMjAyMi0xMS0yMyIsImlhdCI6MTY2OTIwOTA4MSwiZXhwIjoxNjY5Mjk1NDgxLCJqdGkiOiJiOTU1MjlhYi1kZmZjLTRmYjgtYmNiMi02ZmRkZmM1ODU5YWQifQ.bW6AYNeCm0_ja2XF6inGQka1Zyt86uWQAgDXlJZuzSB-dcHeyqerCLlPkc7UEg8WcCm0--vtOtOGiOee85CSrb8TP8iC6Yv-Yoif5VeSkSMxQpBBAK_Wo7P66mUkF6iUCOaKGEFs9Qj7rM1LvWi6ikD4xg-pvR3vfifEbobgL4nN-YF8gx6jZkCfMQNdiSdUNQm7oE17RwHz6zKN9zC6wsmEExt1UhMMgMsp8_0JUCL4JIDPZLptd0aej-Z49W5hBvuJyOovNyQK8QmRwqTy-ej7g4d0XV56GUsNF-43oKkqLPUIFQCXym9C_ZtqN1jXv27PQU6qo5A4Q92Bwih5MA")
        .body("{\"name\":\"idk\",\"price\":\"69.50\",\"place_id\":{\"id\":1}}")
            .when().post("http://localhost:8080/extra/")
            .then()
            .statusCode(200);
    }

    
       
}
