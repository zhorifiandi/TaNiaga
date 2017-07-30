package cidoeq.taniaga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ConfirmPurchase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_purchase);

        ImageView buttonBack = (ImageView) findViewById(R.id.button_confirm_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConfirmPurchase.this, Home.class);
                startActivity(i);
            }
        });

        Button buttonContinue = (Button) findViewById(R.id.button_confirm_continue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConfirmPurchase.this, ConfirmPayment.class);
                startActivity(i);
            }
        });
    }
}
