package okhttp;

import com.google.gson.Gson;
import dto.AuthResponseDTO;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import org.testng.annotations.Test;

public class TestsBase {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();

    String URL_SWAG ="https://contactapp-telran-backend.herokuapp.com";
    String LOGIN_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiZG9tZXM3QG1haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE2OTA5MTA5MTcsImlhdCI6MTY5MDMxMDkxN30.Jc4k5vcsakT5ssXMrZABS16-pSPc0BEqpwc4IZQEF_0";



}
