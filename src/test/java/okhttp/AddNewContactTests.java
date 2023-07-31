package okhttp;

import dto.ReturnContactDTO;
import dto.ContactResponseDTO;
import dto.ErrorDTO;
import helpers.Helper;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddNewContactTests implements Helper {
    String endpoint = "contacts";
    @Test
     public void addNewContactResponse() throws IOException {

        int i = (int)((System.currentTimeMillis()/1000)%3600);
        ReturnContactDTO returnContactDTO = ReturnContactDTO.builder()

                .name("Spider"+i)
                .lastName("Man")
                .email("mail"+i+"@mail.com")
                .phone("123456789"+i)
                .address("world world, "+i)
                .description("description")
                .build();

        RequestBody requestBody = RequestBody.create(gson.toJson(returnContactDTO),JSON);
        Request request = new Request.Builder()
                .url(BASE_URI + "/" + PATH + "/" + endpoint)
                .addHeader("Authorization", TOKEN_INTR)
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());

        if(response.isSuccessful()){
            ContactResponseDTO contactResponseDTO = gson.fromJson(response.body().string(), ContactResponseDTO.class);
            System.out.println(contactResponseDTO.getMessage());
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


    @Test

    public void addNewContactPositive() throws IOException {

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
        String id = message.substring(message.lastIndexOf(" ")+1);

    }
}
