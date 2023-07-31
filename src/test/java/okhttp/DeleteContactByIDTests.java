package okhttp;

import dto.ContactResponseDTO;
import dto.ReturnContactDTO;
import helpers.Helper;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteContactByIDTests implements Helper {
    String endpoint = "contacts";
    String id;

    @BeforeMethod
    public void precondition() throws IOException {

        ReturnContactDTO returnContactDTO = ReturnContactDTO.builder()
                .name("Spider" + i)
                .lastName("Man")
                .email("mail" + i + "@mail.com")
                .phone("1234567" + i)
                .address("world world, " + i)
                .description("description")
                .build();

        RequestBody requestBody = RequestBody.create(gson.toJson(returnContactDTO),JSON);

        Request request = new Request.Builder()
                .url(BASE_URI + "/" + PATH + "/" + endpoint)
                .addHeader(AUTH_HEADER, TOKEN_INTR)
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();

        ContactResponseDTO contactResponceDTO = gson.fromJson(response.body().string(), ContactResponseDTO.class);

        Assert.assertTrue(response.isSuccessful());
        String message = contactResponceDTO.getMessage();
        System.out.println(message);
        // get message, return for me index of last "space" and go to +1
        id = message.substring(message.lastIndexOf(" ")+1);
    }
    @Test
    public void deleteContactPositive() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URI + "/" + PATH + "/" + endpoint + "/" + id)
                .addHeader(AUTH_HEADER, TOKEN_INTR)
                .delete()
                .build();

        Response response = client.newCall(request).execute();

        ContactResponseDTO contactResponceDTO = gson.fromJson(response.body().string(), ContactResponseDTO.class);

        Assert.assertTrue(response.isSuccessful());
        String message = contactResponceDTO.getMessage();
        System.out.println(message);


    }


//TODO
}
