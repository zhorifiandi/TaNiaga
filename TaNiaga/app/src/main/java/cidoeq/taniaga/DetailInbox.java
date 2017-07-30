package cidoeq.taniaga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DetailInbox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_inbox);

        ImageView buttonBack = (ImageView) findViewById(R.id.button_back_detail);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailInbox.this, Inbox.class);
                startActivity(i);
            }
        });

        Button buttonReply = (Button) findViewById(R.id.button_detail_reply);
        buttonReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailInbox.this, ComposeMessage.class);
                startActivity(i);
            }
        });
    }
}
