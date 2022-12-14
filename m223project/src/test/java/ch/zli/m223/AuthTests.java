package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class AuthTests {
    // Outcome should succeed and return a 200
    @Test
    public void testLogin() {
        given().contentType(ContentType.JSON)
            .when().post("http://localhost:8080/auth/login/gianluca.ferrara@gmail.ch/JuveToTheTop69")
            .then()
            .statusCode(200);
    }

    // Outcome should not succeed and return a 204 
    @Test
    public void testLoginWrongUserData() {
        given().contentType(ContentType.JSON)
            .when().post("http://localhost:8080/auth/login/gianlukas.ferrari%bbw.lernende.ch/JuveToTheTop69")
            .then()
            .statusCode(204);
    }

    // Outcome should not succeed and return a 404 bc this Path does not exists 
    @Test
    public void testLoginWrongPath() {
        given().contentType(ContentType.JSON)
            .when().post("http://localhost:8080/auth/login/gianlukas.ferrari%bbw.lernende.ch/JuveToTheTop69/nnucuuanj/129873")
            .then()
            .statusCode(404);
    }

    // Outcome should succeed and return 200 OK
    @Test
    public void testRegister() {
        given().contentType(ContentType.JSON)
          .body("{\"firstname\":\"gigi\",\"lastname\":\"fe\",\"email\":\"gianuca@gmail.com\",\"password\":\"JuveToTheTop69\",\"role\":{\"id\":1}}")
          .when().post("http://localhost:8080/auth/register")
          .then()
             .statusCode(200);
    }




}
