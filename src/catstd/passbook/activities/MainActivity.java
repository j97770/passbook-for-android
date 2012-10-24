package catstd.passbook.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import catstd.passbook.R;

public class MainActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView) findViewById(R.id.m_username)).setText(getIntent().getExtras().getString("username"));
    }
	
}
