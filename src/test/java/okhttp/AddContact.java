package okhttp;

import dto.AddContactResponseDTO;
import dto.ContactResponceDTO;
import dto.ErrorDTO;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddContact extends TestsBase {

    @Test

    public void addNewContactResponse() throws IOException {

        int i = (int)((System.currentTimeMillis()/1000)%3600);
        ContactResponceDTO contactResponceDTO = ContactResponceDTO.builder()
                .id("someid"+i)
                .name("Spider"+i)
                .lastName("Man")
                .email("mail"+i+"@mail.com")
                .phone("123456789"+i)
                .address("world world, "+i)
                .description("description")
                .build();

        RequestBody requestBody = RequestBody.create(gson.toJson(contactResponceDTO),JSON);
        Request request = new Request.Builder()
                .url(URL_SWAG + "/v1/contacts")
                .addHeader("Authorization", LOGIN_TOKEN)
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());

        if(response.isSuccessful()){
            AddContactResponseDTO addContactResponseDTO = gson.fromJson(response.body().string(), AddContactResponseDTO.class);
            System.out.println(addContactResponseDTO.getMessage());
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
