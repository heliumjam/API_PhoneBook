package okhttp;

import dto.AuthRequestDTO;
import dto.ErrorDTO;
import helpers.Helper;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationInterfLesson implements Helper {

    String endpoint ="user/registration/usernamepassword";
    @Test
    public void registrationPositiveLesson() throws IOException {
        AuthRequestDTO requestDTO =  AuthRequestDTO.builder()
                .username("tatatatt"+i + "@mails.com")
                .password("Qq123456$43")
                .build();
        System.out.println(requestDTO.getUsername());


    RequestBody requestBody = RequestBody.create(gson.toJson(requestDTO), JSON);

        Request request = new Request.Builder()
                .url(BASE_URI + "/" + PATH + "/" + endpoint)
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();

        Assert.assertTrue(response.isSuccessful());

}

    @Test
    public void registrationNegativeWrongMail() throws IOException {
        AuthRequestDTO requestDTO =  AuthRequestDTO.builder()
                .username("ttttatattt"+i + "mails.com")
                .password("Qq123456$43")
                .build();


        RequestBody requestBody = RequestBody.create(gson.toJson(requestDTO), JSON);

        Request request = new Request.Builder()
                .url(BASE_URI + "/" + PATH + "/" + endpoint)
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        System.out.println("Response code is-> " +response.code());
        ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
        System.out.println("Status: " + errorDTO.getStatus() + "\n" + errorDTO.getError() + "\n" + errorDTO.getMessage());
        Assert.assertTrue(!response.isSuccessful());

    }
}
