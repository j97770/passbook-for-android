package catstd.passbook.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import catstd.passbook.R;
import catstd.passbook.dao.dto.User;

public class RegistrationActivity extends Activity {

    private EditText username;
    private EditText fullname;
    private EditText password;
    private EditText confirm;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        
        username = (EditText) findViewById(R.id.r_username);
        fullname = (EditText) findViewById(R.id.r_fullname);
        password = (EditText) findViewById(R.id.r_password);
        confirm  = (EditText) findViewById(R.id.r_confirm);
    }
    
    public void cancel(View view) {
        finish();
    }
    
    @SuppressWarnings("unused")
    public void register(View view) {
        String username = this.username.getText().toString();
        String fullname = this.fullname.getText().toString();
        String password = this.password.getText().toString();
        String confirm  = this.confirm.getText().toString();
        //TODO: check
        User user = new User();
        //TODO: register
        Intent intent = new Intent(this, MainActivity.class);
        //TODO: send user to next activity
        intent.putExtra("username", username);
        startActivity(intent);
        finish();
    }
    
}
