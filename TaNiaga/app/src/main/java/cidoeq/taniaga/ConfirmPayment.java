package cidoeq.taniaga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ConfirmPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_payment);

        ImageView buttonBack = (ImageView) findViewById(R.id.button_confirm_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConfirmPayment.this, Home.class);
                startActivity(i);
            }
        });

        Button buttonDone = (Button) findViewById(R.id.button_done);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConfirmPayment.this, Home.class);
                startActivity(i);
            }
        });
    }
}
