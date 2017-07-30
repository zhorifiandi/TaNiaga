package cidoeq.taniaga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import cidoeq.taniaga.Helper.SharedPrefManager;

public class Profile extends AppCompatActivity {

    public Boolean isPenjual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView buttonBack = (ImageView) findViewById(R.id.button_back_profile);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);
            }
        });

        Button buttonHistory = (Button) findViewById(R.id.button_riwayat);
        isPenjual = true;
        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                if (isPenjual){
                    i = new Intent(Profile.this, SoldHistory.class);
                } else {
                    i = new Intent(Profile.this, PurchaseHistory.class);
                }
                startActivity(i);
            }
        });

        Button buttonSoldItem = (Button) findViewById(R.id.button_daftar_produk);
        isPenjual = true;
        buttonSoldItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                if (isPenjual){
                    i = new Intent(Profile.this, SoldItem.class);
                } else {
                    i = new Intent(Profile.this, PurchaseHistory.class);
                }
                startActivity(i);
            }
        });

        Button buttonLogout = (Button) findViewById(R.id.button_logout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPrefManager.getInstance(Profile.this).saveDeviceToken(null);
                Intent i;
                    i = new Intent(Profile.this, Login.class);

                startActivity(i);
            }
        });


    }
}
