package catstd.passbook;

import catstd.passbook.activities.LoginActivity;
import catstd.passbook.activities.RegistrationActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class PassbookActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_passbook);

		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_passbook, menu);
		return true;
	}
}
