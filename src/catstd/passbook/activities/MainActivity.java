package catstd.passbook.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;
import catstd.passbook.Constants;
import catstd.passbook.R;
import catstd.passbook.activities.parcelable.UserParcelable;

public class MainActivity extends AbstractActivity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        UserParcelable user = getIntent().getExtras().getParcelable(Constants.EXTRA_USER);
        ((TextView) findViewById(R.id.m_username)).setText(user.getUsername());
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_main_activity, menu);
		return true;
	}
	
}
