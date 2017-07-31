package cidoeq.taniaga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cidoeq.taniaga.Helper.SharedPrefManager;
import cidoeq.taniaga.Model.User;
import cidoeq.taniaga.Service.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    Call<User> responseCallForRetrieve;

    //defining views
    private EditText editTextEmail;
    private EditText editTextName;
    private EditText editTextPhone;
    private EditText editTextAddress;
    private EditText editTextPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageView buttonBack = (ImageView) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
            }
        });


        buttonRegister = (Button) findViewById(R.id.button_register);


        Spinner spinnerJenisAkun = (Spinner) findViewById(R.id.spinner_jenis_akun);
        List<String> tempJenisAkun = new ArrayList<String>();
        tempJenisAkun.add("Pembeli");
        tempJenisAkun.add("Mitra Tani");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tempJenisAkun);
        spinnerJenisAkun.setAdapter(dataAdapter);

        editTextEmail = (EditText) findViewById(R.id.edit_email);
        editTextName = (EditText) findViewById(R.id.edit_name);
        editTextPhone = (EditText) findViewById(R.id.edit_no_hp);
        editTextAddress = (EditText) findViewById(R.id.edit_alamat);
        editTextPassword = (EditText) findViewById(R.id.edit_password);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });


        

    }

    private void register() {
        final String email = editTextEmail.getText().toString().trim();
        final String password  = editTextPassword.getText().toString().trim();
        final String name  = editTextName.getText().toString().trim();
        final String phone  = editTextPhone.getText().toString().trim();
//        final String address  = editTextAddress.getText().toString().trim();
        final String address  = "dummy";

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Please enter name",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(phone)){
            Toast.makeText(this,"Please enter phone",Toast.LENGTH_LONG).show();
            return;
        }

//        if(TextUtils.isEmpty(address)){
//            Toast.makeText(this,"Please enter address",Toast.LENGTH_LONG).show();
//            return;
//        }

        responseCallForRetrieve = APIService.service.SignUp(email, password,name, address, phone);
        responseCallForRetrieve.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    User user = response.body();
                    System.out.println("HASILNYA:");
                    System.out.println(user.getEmail());
                    finish();
                    startActivity(new Intent(getApplicationContext(), Login.class));
                }
                else {

                    System.out.println(response.message());
                    System.out.println("Gagal");
//                    progressDialog.dismiss();

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });


    }

}
