package restassured;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.AuthRequestDTO;
import dto.AuthResponseDTO;
import helpers.Helper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class LoginTestsRA implements Helper {
    String endpoint = "user/login/usernamepassword";

    @BeforeMethod
    public void precondition(){
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = PATH;
    }


    @Test
    public void loginPositive(){
        AuthRequestDTO requestDTO = AuthRequestDTO.builder()
                .username("domes7@mail.com")
                .password("123456Aa$")
                .build();

        AuthResponseDTO responseDTO = given()
                .body(requestDTO)
                .contentType(ContentType.JSON)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(200)
                .extract()
                .as(AuthResponseDTO.class);

        System.out.println(responseDTO.getToken());

    }
}
