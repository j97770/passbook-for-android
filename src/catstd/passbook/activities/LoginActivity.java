package catstd.passbook.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import catstd.passbook.R;

public class LoginActivity extends Activity {
	private EditText username;
	private EditText password;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		username = (EditText) findViewById(R.id.l_username);
		password = (EditText) findViewById(R.id.l_password);
	}

	public void login(View view) {
		String username = this.username.getText().toString();
		String password = this.password.getText().toString();
	}

	public void registration(View view) {
		
	}

}
