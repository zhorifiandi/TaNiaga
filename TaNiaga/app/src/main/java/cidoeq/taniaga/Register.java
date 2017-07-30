package cidoeq.taniaga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {

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


        Button buttonRegister = (Button) findViewById(R.id.button_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, Home.class);
                startActivity(i);
            }
        });

        Spinner spinnerJenisAkun = (Spinner) findViewById(R.id.spinner_jenis_akun);
        List<String> tempJenisAkun = new ArrayList<String>();
        tempJenisAkun.add("Pembeli");
        tempJenisAkun.add("Mitra Tani");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tempJenisAkun);
        spinnerJenisAkun.setAdapter(dataAdapter);
        
        register();
    }

    private void register() {


    }

}
