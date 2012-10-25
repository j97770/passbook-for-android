package catstd.passbook.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import catstd.passbook.Constants;
import catstd.passbook.R;
import catstd.passbook.activities.parcelable.UserParcelable;

public class MainActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserParcelable user = getIntent().getExtras().getParcelable(Constants.EXTRA_USER);
        ((TextView) findViewById(R.id.m_username)).setText(user.getUsername());
    }
	
}
