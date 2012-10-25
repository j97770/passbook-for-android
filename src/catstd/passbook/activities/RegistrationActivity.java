package catstd.passbook.activities;

import java.util.logging.Logger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import catstd.passbook.Constants;
import catstd.passbook.R;
import catstd.passbook.dao.PersistanceException;
import catstd.passbook.dao.UserDAO;
import catstd.passbook.dao.dto.User;
import catstd.passbook.utils.Assembler;

public class RegistrationActivity extends Activity {

    private static final Logger LOG = Logger.getLogger(RegistrationActivity.class.getSimpleName()); 
    
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
        
        try {
            UserDAO userDAO = Constants.getFactory().getUserDAO();
            if(userDAO.exist(username)) {
                //TODO: show dialog user exists, choose another
                return;
            }
            if(password.length() == 0) {
                //TODO: show dialog password lenght must not be empty
                return;
            }
            if(!password.equals(confirm)) {
                //TODO: show dialog different passwords
                return;
            }
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userDAO.persist(user);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(Constants.EXTRA_USER, Assembler.assemble(user));
            startActivity(intent);
            finish();
        } catch (PersistanceException e) {
            LOG.severe(e.getMessage());
            //TODO: show message
        }
    }
    
}
