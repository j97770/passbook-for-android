package catstd.passbook;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PassbookActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passbook);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_passbook, menu);
        return true;
    }
}
