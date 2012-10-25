package catstd.passbook;

import java.util.logging.Logger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import catstd.passbook.activities.RegistrationActivity;
import catstd.passbook.dao.DaoFactory;

public class PassbookActivity extends Activity {

    private static final Logger LOG = Logger.getLogger(PassbookActivity.class.getName());
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passbook);
        try {
            //init constants
            DaoFactory factory = DaoFactory.newInstance(DaoFactory.MOCK);
            Constants.setFactory(factory);
            //open next activity
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
            finish();
        } catch(InstantiationException e) {
            LOG.severe(e.getMessage());
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_passbook, menu);
        return true;
    }
}
