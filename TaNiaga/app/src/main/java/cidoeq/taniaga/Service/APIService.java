package cidoeq.taniaga.Service;

import java.util.List;

import cidoeq.taniaga.Model.Item;
import cidoeq.taniaga.Model.Transaction;
import cidoeq.taniaga.Model.User;


// Retrofit Package
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by zhorifiandi on 7/30/17.
 */

public interface APIService {
    public static final String API_URL = "http://192.168.43.239:3000/";

    @POST("authenticate")
    Call<User> getToken(@Query("email") String email, @Query("password") String password);

    @POST("show_by_email")
    Call<User> getUserInfo(@Query("email") String email, @Header("Authorization") String token);

    @GET("items")
    Call<List<Item>> getItems(@Header("Authorization") String token);

    @POST("transactions")
    Call<Transaction> makeTranscation(@Header("Authorization") String token, @Query("item_id") int item_id, @Query("seller_id") int seller_id, @Query("buyer_id") int buyer_id, @Query("item_name") String item_name, @Query("item_name") String seller_name, @Query("buyer_name") String buyer_name, @Query("amount_price") int amount_price, @Query("description") String description);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    APIService service = retrofit.create(APIService.class);
}
