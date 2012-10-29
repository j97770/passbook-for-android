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

public class LoginActivity extends Activity {
	private static final Logger LOG = Logger
			.getLogger(RegistrationActivity.class.getSimpleName());
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

		try {
			UserDAO userDAO = Constants.getFactory().getUserDAO();
			if (!userDAO.exist(username)) {
				// TODO: show dialog user is not exists, try again
				return;
			}

			User login = userDAO.get(username, password);

			Intent intent = new Intent(this, MainActivity.class);
			intent.putExtra(Constants.EXTRA_USER, Assembler.assemble(login));
			startActivity(intent);

		} catch (PersistanceException e) {
			LOG.severe(e.getMessage());
			// TODO: show message
		}
	}

	public void registration(View view) {
		Intent intent = new Intent(this, RegistrationActivity.class);
		startActivity(intent);

	}

}
