package catstd.passbook.activities;

import java.util.logging.Logger;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import catstd.passbook.Constants;
import catstd.passbook.R;
import catstd.passbook.dao.PersistanceException;
import catstd.passbook.dao.UserDAO;
import catstd.passbook.dao.ValidationException;
import catstd.passbook.dao.dto.User;

public class LoginActivity extends AbstractActivity {
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
				AlertDialog builder = new AlertDialog.Builder(this).create();
				builder.setTitle("Warning");
				builder.setMessage("Invalid Login or Password");
				builder.setButton(AlertDialog.BUTTON_NEUTRAL, getResources()
						.getString(R.string.ok),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
							}
						});
				builder.show();
				return;
			}
			if (!userDAO.exist(username)) {

			}
			User user = userDAO.get(username, password);
			openMainActivity(user);

		} catch (ValidationException e) {
			LOG.severe(e.getMessage());

		} catch (PersistanceException e) {
			LOG.severe(e.getMessage());

		}
	}

	public void registration(View view) {
		openRegistrationActivity();

	}

}
