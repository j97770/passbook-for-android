package catstd.passbook;

import java.util.logging.Logger;

import android.os.Bundle;
import catstd.passbook.activities.AbstractActivity;
import catstd.passbook.dao.DaoFactory;

public class PassbookActivity extends AbstractActivity {

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
            openLoginActivity();
            finish();
            
        } catch(InstantiationException e) {
            LOG.severe(e.getMessage());
        }
    }
    
}
