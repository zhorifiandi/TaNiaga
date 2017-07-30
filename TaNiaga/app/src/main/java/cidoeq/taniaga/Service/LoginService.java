package cidoeq.taniaga.Service;

import cidoeq.taniaga.Model.User;


// Retrofit Package
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by zhorifiandi on 7/30/17.
 */

public interface LoginService {
    public static final String API_URL = "http://192.168.43.239:3000/";

    @POST("authenticate")
    Call<User> getToken(@Query("email") String email, @Query("password") String password);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    LoginService service = retrofit.create(LoginService.class);
}
