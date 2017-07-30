package cidoeq.taniaga;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import cidoeq.taniaga.Helper.SharedPrefManager;

public class Home extends AppCompatActivity {

    public String auth_token = SharedPrefManager.getInstance(Home.this).getDeviceToken();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final EditText editSearch= (EditText) findViewById(R.id.edit_search);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
        editSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editSearch.getWindowToken(), 0);
                }
            }
        });
        editSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == editSearch.getId())
                {
                    editSearch.setCursorVisible(true);
                } else {
                    editSearch.setCursorVisible(false);
                }
            }
        });

        System.out.println("FROM HOME, TOKEN:");
        System.out.println(auth_token);
    }
}
