package restassured;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.AuthRequestDTO;
import dto.AuthResponseDTO;
import helpers.Helper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class RegistrationTestsRA implements Helper {
    String endpoint = "/user/registration/usernamepassword";

    @BeforeMethod
    public void precondition(){
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = PATH;
    }

    @Test
    public void RegistrationPositive(){
        AuthRequestDTO requestDTO =  AuthRequestDTO.builder()
                .username("tatatatt"+i + "@mails.com")
                .password("Qq123456$43")
                .build();

        AuthResponseDTO responseDTO = given()   //dano
                .body(requestDTO)               //we have body (content)
                .contentType(ContentType.JSON)  // content type
                .when()
                .post(endpoint)                     //when method post go to endpoint
                .then()
                .assertThat().statusCode(200)    // then i claim that status code is 200
                .extract()                                      // extract  content
                .as(AuthResponseDTO.class);                     // in format of class ...

        System.out.println(responseDTO.getToken());
    }


}
