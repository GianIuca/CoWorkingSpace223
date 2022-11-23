package ch.zli.m223;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UserTests {
    // Should not succeed bc only the admin has rights to see them
    @Test
    public void testgetUserssAsMitglied() {
            given()
                .header("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3psaS5leGFtcGxlLmNvbS8iLCJ1cG4iOiJqZG9lQHF1YXJrdXMuaW8iLCJncm91cHMiOlsiTWl0Z2xpZWQiXSwiYmlydGhkYXRlIjoiMjAyMi0xMS0yMyIsImlhdCI6MTY2OTIwOTA4MSwiZXhwIjoxNjY5Mjk1NDgxLCJqdGkiOiJiOTU1MjlhYi1kZmZjLTRmYjgtYmNiMi02ZmRkZmM1ODU5YWQifQ.bW6AYNeCm0_ja2XF6inGQka1Zyt86uWQAgDXlJZuzSB-dcHeyqerCLlPkc7UEg8WcCm0--vtOtOGiOee85CSrb8TP8iC6Yv-Yoif5VeSkSMxQpBBAK_Wo7P66mUkF6iUCOaKGEFs9Qj7rM1LvWi6ikD4xg-pvR3vfifEbobgL4nN-YF8gx6jZkCfMQNdiSdUNQm7oE17RwHz6zKN9zC6wsmEExt1UhMMgMsp8_0JUCL4JIDPZLptd0aej-Z49W5hBvuJyOovNyQK8QmRwqTy-ej7g4d0XV56GUsNF-43oKkqLPUIFQCXym9C_ZtqN1jXv27PQU6qo5A4Q92Bwih5MA")
                .when().get("http://localhost:8080/user/")
                .then()
                .statusCode(403);
    }

    // Should succeed bc only the admin has rights
    @Test
    public void testgetUsersAsAdmin() {
            given()
                .header("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3psaS5leGFtcGxlLmNvbS8iLCJ1cG4iOiJqZG9lQHF1YXJrdXMuaW8iLCJncm91cHMiOlsiTWl0Z2xpZWQiXSwiYmlydGhkYXRlIjoiMjAyMi0xMS0yMyIsImlhdCI6MTY2OTIxMzM4MCwiZXhwIjoxNjY5Mjk5NzgwLCJqdGkiOiIyYjkzMzYzNi1lZjQ5LTQ3M2YtYmQyNy01YTdmMTU4NmQ5OWMifQ.h620T9moc0ttMuyHI_RnrPdgfpcB5C_VpOGLiizOpwTN7hIFQjC9xp6x9PeuW7PiKpkBcskYxNVjA0CwzR676cruiVgOrzU2ChsgOpBNeHBI6Wc13SKcD2sYi52Y_sFO30JTkTwejnAh0-LnDNU6PGxZXc71uUWHspu2CAFwQUu8AOkhypf88WyB0bE86Y29R44u4T626SeJ6HwRXTDu-0Y-acgo4Qb47um0ycmlWJoF3U8D73rfJnba9g2o3-Gj3HNxniwfI4l7LUhA-Gi6MBmh_Eb-JTKLLymD6BjqQlWb8dKpNj-KE9wWO-zuaO9SuS62ZWyTRXllqKqZ0S-DfQ")
                .when().get("http://localhost:8080/user/")
                .then()
                .statusCode(200);
    }

    @Test
    public void testAddNewUserByUser() {
        given().contentType(ContentType.JSON)
        .body("{\"email\":\"gigi@gmail.ch\",\"firstname\":\"gigi\",\"lastname\":\"ferrari\",\"password\":\"JUVEEE\",\"role_id\":{\"id\":1}}")
            .when().post("http://localhost:8080/user/")
            .then()
            .statusCode(401);
    }

    @Test
    public void testAddNewUserByAdmin() {
        given().contentType(ContentType.JSON)
        .header("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3psaS5leGFtcGxlLmNvbS8iLCJ1cG4iOiJqZG9lQHF1YXJrdXMuaW8iLCJncm91cHMiOlsiTWl0Z2xpZWQiXSwiYmlydGhkYXRlIjoiMjAyMi0xMS0yMyIsImlhdCI6MTY2OTIxMzM4MCwiZXhwIjoxNjY5Mjk5NzgwLCJqdGkiOiIyYjkzMzYzNi1lZjQ5LTQ3M2YtYmQyNy01YTdmMTU4NmQ5OWMifQ.h620T9moc0ttMuyHI_RnrPdgfpcB5C_VpOGLiizOpwTN7hIFQjC9xp6x9PeuW7PiKpkBcskYxNVjA0CwzR676cruiVgOrzU2ChsgOpBNeHBI6Wc13SKcD2sYi52Y_sFO30JTkTwejnAh0-LnDNU6PGxZXc71uUWHspu2CAFwQUu8AOkhypf88WyB0bE86Y29R44u4T626SeJ6HwRXTDu-0Y-acgo4Qb47um0ycmlWJoF3U8D73rfJnba9g2o3-Gj3HNxniwfI4l7LUhA-Gi6MBmh_Eb-JTKLLymD6BjqQlWb8dKpNj-KE9wWO-zuaO9SuS62ZWyTRXllqKqZ0S-DfQ")
        .body("{\"email\":\"gigi@gmail.ch\",\"firstname\":\"gigi\",\"lastname\":\"ferrari\",\"password\":\"JUVEEE\",\"role_id\":{\"id\":1}}")
            .when().post("http://localhost:8080/user/")
            .then()
            .statusCode(403);
    }






}
