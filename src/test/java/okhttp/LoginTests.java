package okhttp;

import com.google.gson.Gson;
import dto.AuthRequestDTO;
import dto.AuthResponseDTO;
import dto.ErrorDTO;
import helpers.Helper;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests implements Helper {

    @Test
    public void loginPositive() throws IOException {
// create object for request
        AuthRequestDTO requestDTO = AuthRequestDTO.builder()
                .username("domes7@mail.com")
                .password("123456Aa$")
                .build();
// change object type to json
    RequestBody requestBody = RequestBody.create(gson.toJson(requestDTO),JSON);
// create request, first url then type of request
        Request request = new Request.Builder() // no flash in the end
                .url(BASE_URI+"/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();
// get response from server when it will be sent
// we use client and make request
// execute throw exeption
        Response response = client.newCall(request).execute();

        if (response.isSuccessful()){ // if response 200 - will be true
// 1 response.body().string() return string in json format
         AuthResponseDTO authResponseDTO = gson.fromJson(response.body().string(), AuthResponseDTO.class);
            System.out.println(authResponseDTO.getToken());
            System.out.println("Response code is-> " +response.code());
            ///LOGIN_TOKEN = responseDTO.getToken();
           // System.out.println("TOKEN is-> " +LOGIN_TOKEN);
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



