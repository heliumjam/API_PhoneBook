package helpers;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import java.util.Random;

public interface Helper {
    MediaType JSON = MediaType.get("application/json; charset=utf-8");
    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();

    String TOKEN_INTR = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiZG9tZXM3QG1haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE2OTEzMzEzMDYsImlhdCI6MTY5MDczMTMwNn0.z_Y6dSUDg_C2ea1ElCNzq1QkGIvEew80PeJ0EEjzRsE";
    String BASE_URI ="https://contactapp-telran-backend.herokuapp.com";

    String PATH = "v1";
    String AUTH_HEADER = "Authorization";


//    int i = new Random.nextInt(1000)+1000;
   // int i = 3838387;
    int i = new Random().nextInt(1000);



}
