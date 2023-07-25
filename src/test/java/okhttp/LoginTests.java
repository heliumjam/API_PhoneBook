package okhttp;

import com.google.gson.Gson;
import dto.AuthRequestDTO;
import dto.AuthResponseDTO;
import dto.ErrorDTO;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests extends TestsBase{

    @Test
    public void loginPositive() throws IOException {

        AuthRequestDTO requestDTO = AuthRequestDTO.builder()
                .username("domes7@mail.com")
                .password("123456Aa$")
                .build();

    RequestBody requestBody = RequestBody.create(gson.toJson(requestDTO),JSON);

        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()){
         AuthResponseDTO responseDTO = gson.fromJson(response.body().string(), AuthResponseDTO.class);
            System.out.println(responseDTO.getToken());
            System.out.println("Response code is-> " +response.code());
            TOKEN = responseDTO.getToken();
            System.out.println("TOKEN is-> " +TOKEN);
            Assert.assertTrue(response.isSuccessful());
        }
        else{
            System.out.println("Response code is-> " +response.code());
            ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
            System.out.println("Status: " + errorDTO.getStatus() + "\n" + errorDTO.getError() + "\n" + errorDTO.getMessage());
            Assert.assertFalse(response.isSuccessful());
        }

    }

 }



