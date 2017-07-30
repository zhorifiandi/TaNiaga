package cidoeq.taniaga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Inbox extends AppCompatActivity implements View.OnClickListener{

    public ImageView buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);

        buttonBack = (ImageView) findViewById(R.id.button_back_inbox);
        buttonBack.setOnClickListener(this);

        Button buttonCompose = (Button) findViewById(R.id.button_inbox_compose);
        buttonCompose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Inbox.this, ComposeMessage.class);
                startActivity(i);
            }
        });

        Button buttonContact = (Button) findViewById(R.id.button_inbox_contact);
        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Inbox.this, Contact.class);
                startActivity(i);
            }
        });

        Button buttonSent = (Button) findViewById(R.id.button_inbox_sent);
        buttonSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Inbox.this, SentMessage.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onClick(View v){
        if (v == buttonBack ) {
            Intent i = new Intent(Inbox.this, Home.class);
            startActivity(i);
        }

    }
}
