package cidoeq.taniaga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DeleteProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_product);

        ImageView buttonBack = (ImageView) findViewById(R.id.button_compose_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DeleteProduct.this, SoldItem.class);
                startActivity(i);
            }
        });

        Button buttonYes = (Button) findViewById(R.id.button_delete_yes);
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DeleteProduct.this, SoldItem.class);
                startActivity(i);
            }
        });

        Button buttonNo = (Button) findViewById(R.id.button_delete_no);
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DeleteProduct.this, SoldItem.class);
                startActivity(i);
            }
        });
    }
}
