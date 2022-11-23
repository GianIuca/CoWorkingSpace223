package ch.zli.m223;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PlacesTests {
    // Should succeed bc everyone has rights to see them
    @Test
    public void testgetPlacesAsMember() {
            given()
                .header("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3psaS5leGFtcGxlLmNvbS8iLCJ1cG4iOiJqZG9lQHF1YXJrdXMuaW8iLCJncm91cHMiOlsiTWl0Z2xpZWQiXSwiYmlydGhkYXRlIjoiMjAyMi0xMS0yMyIsImlhdCI6MTY2OTIwOTA4MSwiZXhwIjoxNjY5Mjk1NDgxLCJqdGkiOiJiOTU1MjlhYi1kZmZjLTRmYjgtYmNiMi02ZmRkZmM1ODU5YWQifQ.bW6AYNeCm0_ja2XF6inGQka1Zyt86uWQAgDXlJZuzSB-dcHeyqerCLlPkc7UEg8WcCm0--vtOtOGiOee85CSrb8TP8iC6Yv-Yoif5VeSkSMxQpBBAK_Wo7P66mUkF6iUCOaKGEFs9Qj7rM1LvWi6ikD4xg-pvR3vfifEbobgL4nN-YF8gx6jZkCfMQNdiSdUNQm7oE17RwHz6zKN9zC6wsmEExt1UhMMgMsp8_0JUCL4JIDPZLptd0aej-Z49W5hBvuJyOovNyQK8QmRwqTy-ej7g4d0XV56GUsNF-43oKkqLPUIFQCXym9C_ZtqN1jXv27PQU6qo5A4Q92Bwih5MA")
                .when().get("http://localhost:8080/place/" + 1)
                .then()
                .statusCode(200);
    }

    // Should succeed bc admin has rights
    @Test
    public void testgetPlacesAsAdmin() {
            given()
                .header("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3psaS5leGFtcGxlLmNvbS8iLCJ1cG4iOiJqZG9lQHF1YXJrdXMuaW8iLCJncm91cHMiOlsiTWl0Z2xpZWQiXSwiYmlydGhkYXRlIjoiMjAyMi0xMS0yMyIsImlhdCI6MTY2OTIwODg4MywiZXhwIjoxNjY5Mjk1MjgzLCJqdGkiOiI1NjE0MTExMC0yMTI0LTRhNWYtODE1Zi02YTUxMDA2MmY3MDkifQ.SWLLjtaclhn0MS2u0uF71jVZhg7dvhVfF78k7XpPIdQNxbobbvepFF7zMp7VVmKvbgmRrPWKvSz3H2UOsunVxXcFRa0vFK2k_eipbCY1kTbwHp4KaoMiuB14okdLh-TaFZKPYBqGs6LKERaFdfHa20_LoHp5iLC-O0PUWi36B00Ul4tUsyGp1h1Au7l0xaCU3h-y9whdyMYPytNq3t033u5E3ztDgOV_BMr0LovNO76nOEEuZsqUiWyuW70-AnqIph9k_D3ncd-L-NxI7fypCPdyNHRBMgcJnI7-cANwzGZtlurX3C0Otchx3g4p1yJ_INLqgKQ6nCN-5W-mTWmVEw")
                .when().get("http://localhost:8080/place/" + 1)
                .then()
                .statusCode(200);
    }

    // Should not succeed bc its a wrong path
    @Test
    public void testgetBookingsWrongPath() {
            given()
                .when().get("http://localhost:8080/places/1/" + 1)
                .then()
                .statusCode(404);
    }
}
