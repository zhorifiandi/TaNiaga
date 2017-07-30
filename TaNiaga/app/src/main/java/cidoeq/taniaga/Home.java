package cidoeq.taniaga;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Iterator;
import java.util.List;

import cidoeq.taniaga.Helper.SharedPrefManager;
import cidoeq.taniaga.Model.Item;
import cidoeq.taniaga.Model.User;
import cidoeq.taniaga.Service.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {

    public String auth_token = SharedPrefManager.getInstance(Home.this).getDeviceToken();
    final User current_user = SharedPrefManager.getInstance(Home.this).getUser();
    Call<List<Item>> responseCallForRetrieve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final EditText editSearch= (EditText) findViewById(R.id.edit_search);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
        editSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editSearch.getWindowToken(), 0);
                }
            }
        });
        editSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == editSearch.getId())
                {
                    editSearch.setCursorVisible(true);
                } else {
                    editSearch.setCursorVisible(false);
                }
            }
        });

        ImageView buttonProfile = (ImageView) findViewById(R.id.button_home_profile);
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Profile.class);
                startActivity(i);
            }
        });

        ImageView buttonMessage = (ImageView) findViewById(R.id.button_home_message);
        buttonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Inbox.class);
                startActivity(i);
            }
        });

        retrieveItems(auth_token);

        System.out.println("FROM HOME, TOKEN:");
        System.out.println(auth_token);
        System.out.println(current_user.getEmail());
        System.out.println(current_user.getName());
        System.out.println(current_user.getAddress());
        System.out.println(current_user.getPhonenumber());
    }

    private void retrieveItems(String token) {
        System.out.println("retrieveeee");
        responseCallForRetrieve = APIService.service.getItems(token);
        responseCallForRetrieve.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful()){
                    List<Item> body = response.body();
                    System.out.println("HOME HASILNYA:");
                    for (Iterator<Item> i = body.iterator(); i.hasNext();){
                        Item item = i.next();
                        System.out.println("id : " + item.getId());
                        System.out.println("Name : " + item.getName());
                        System.out.println("Category : " + item.getCategory());
                        System.out.println("Price : " + item.getPrice());
                        System.out.println("Desc : " + item.getDescription());
                        System.out.println("Dim : " + item.getDimension());
                        System.out.println("Sel : " + item.getSeller_email());
                        System.out.println("Var : " + item.getVariety());
                    }
                }
                else {

                    System.out.println(response.message());
                    System.out.println("Gagal");

                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                System.out.println("On Failure");

            }
        });
    }
}
