package cidoeq.taniaga;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cidoeq.taniaga.Helper.SharedPrefManager;
import cidoeq.taniaga.Model.User;
import cidoeq.taniaga.Service.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Call<User> responseCallForLogin;
    Call<User> responseCallForRetrieve;

    //defining views
    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView buttonRegister;

    //progress dialog
    private ProgressDialog progressDialog;



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolean isLoggedin = false;

        if (SharedPrefManager.getInstance(Login.this).getDeviceToken() != null) {
            System.out.println("Already Logged in");
            super.onCreate(savedInstanceState);
            finish();
            startActivity(new Intent(getApplicationContext(), Home.class));
        }
        else {
            System.out.println("Belum Logged in");
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            Window windowLogin = getWindow();
            windowLogin.setStatusBarColor(Color.rgb(0, 102, 61));


            //initializing views
            editTextEmail = (EditText) findViewById(R.id.email_login);
            editTextPassword = (EditText) findViewById(R.id.password_login);
            buttonSignIn = (Button) findViewById(R.id.button_login);
            buttonRegister = (TextView) findViewById(R.id.button_login_register);

            //attaching click listener
            buttonSignIn.setOnClickListener(this);
            buttonRegister.setOnClickListener(this);

            progressDialog = new ProgressDialog(this);
        }


    }

    @Override
    public void onClick(View v) {
        if(v == buttonSignIn){
            userLogin();
        } else if (v == buttonRegister){
            Intent i = new Intent(Login.this, Register.class);
            startActivity(i);
        }

    }

    private void userLogin() {
        final String email = editTextEmail.getText().toString().trim();
        final String password  = editTextPassword.getText().toString().trim();


        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog


        progressDialog.setMessage("Logging in...");
        progressDialog.show();

        responseCallForLogin = APIService.service.getToken(email, password);

        responseCallForLogin.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    User body = response.body();
                    System.out.println("HASILNYA:");
                    System.out.println(body.getAuthToken());
                    SharedPrefManager.getInstance(Login.this).saveDeviceToken(body.getAuthToken());
                    retrieveUser(email,body.getAuthToken());
                    progressDialog.dismiss();
                    finish();
                    startActivity(new Intent(getApplicationContext(), Home.class));
                }
                else {

                    System.out.println(response.message());
                    System.out.println("Gagal");
                    progressDialog.dismiss();

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    void retrieveUser(String email, String token) {
        responseCallForRetrieve = APIService.service.getUserInfo(email, token);
        responseCallForRetrieve.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    User body = response.body();
                    System.out.println("HASILNYA:");
                    System.out.println(body.getEmail());
                    System.out.println(body.getName());
                    System.out.println(body.getAddress());
                    System.out.println(body.getPhonenumber());
                    SharedPrefManager.getInstance(Login.this).saveUserInfo(body);
                }
                else {

                    System.out.println(response.message());
                    System.out.println("Gagal");

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
