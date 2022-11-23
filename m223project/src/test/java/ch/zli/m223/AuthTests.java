package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class AuthTests {
    // Outcome should succed and return a 200
    @Test
    public void testLogin() {
        given().contentType(ContentType.JSON)
            .when().post("http://localhost:8080/auth/login/gianluca.ferrara@gmail.ch/JuveToTheTop69")
            .then()
            .statusCode(200);
    }

    // Outcome should not succed and return a 204 
    @Test
    public void testLoginWrongInput() {
        given()
            .when().post("http://localhost:8080/auth/login/gianlukas.ferrari%bbw.lernende.ch/JuveToTheTop69")
            .then()
            .statusCode(204);
    }

    

}
