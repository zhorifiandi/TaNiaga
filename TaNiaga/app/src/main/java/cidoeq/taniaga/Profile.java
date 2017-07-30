package cidoeq.taniaga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView buttonBack = (ImageView) findViewById(R.id.button_back_profile);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, Home.class);
                startActivity(i);
            }
        });

        Button buttonHistory = (Button) findViewById(R.id.button_riwayat);
        final Boolean isPenjual = true;
        buttonBack.setOnClickListener(new View.OnClickListener() {
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
    }
}
