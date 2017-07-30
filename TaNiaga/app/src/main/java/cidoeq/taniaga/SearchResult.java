package cidoeq.taniaga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class SearchResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);


        ImageView buttonBack = (ImageView) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SearchResult.this, Home.class);
                startActivity(i);
            }
        });

        ListView listBarangBarangHasilPencarian = (ListView) findViewById(R.id.list_view_for_search_result);
        ItemAdapter searchResultAdapter = new ItemAdapter(this, 10);
        listBarangBarangHasilPencarian.setAdapter(searchResultAdapter);


    }
}
