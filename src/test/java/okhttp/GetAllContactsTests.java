package okhttp;

import dto.ReturnContactDTO;
import dto.ContactListDTO;
import helpers.Helper;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetAllContactsTests implements Helper {

    @Test
    public void getAllContactsPositive() throws IOException {

        Request request = new Request.Builder()
                .url(BASE_URI + "/v1/contacts")
                .addHeader("Authorization", TOKEN_INTR)
                .build();

        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());

        ContactListDTO contacts = gson.fromJson(response.body().string(), ContactListDTO.class);

        for(ReturnContactDTO returnContactDTO : contacts.getContacts()){
            System.out.println(returnContactDTO.getId());
            System.out.println(returnContactDTO.getEmail());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        }
    }

}
