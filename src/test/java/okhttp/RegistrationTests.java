package okhttp;

import dto.AuthRequestDTO;
import dto.AuthResponseDTO;
import dto.ErrorDTO;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTests extends TestsBase{

    @Test
        public void registrationPositive() throws IOException {
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        AuthRequestDTO requestDTO = AuthRequestDTO.builder()
                .username("domesapi"+i+"@mail.com")
                .password("123456Aa$")
                .build();

        RequestBody requestBody = RequestBody.create(gson.toJson(requestDTO),JSON);

        Request request = new Request.Builder()
                .url(URL_SWAG +"/v1/user/registration/usernamepassword")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();

        if(response.isSuccessful()) {
            AuthResponseDTO responseDTO = gson.fromJson(response.body().string(), AuthResponseDTO.class);
            System.out.println(responseDTO.getToken());
            System.out.println("Response code is-> " +response.code());
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
