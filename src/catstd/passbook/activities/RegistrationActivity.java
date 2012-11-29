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
import catstd.passbook.dao.dto.User;

public class RegistrationActivity extends AbstractActivity {

	private static final Logger LOG = Logger
			.getLogger(RegistrationActivity.class.getSimpleName());

	private EditText username;
	private EditText fullname;
	private EditText password;
	private EditText confirm;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);

		username = (EditText) findViewById(R.id.r_username);
		fullname = (EditText) findViewById(R.id.r_fullname);
		password = (EditText) findViewById(R.id.r_password);
		confirm = (EditText) findViewById(R.id.r_confirm);
	}

	public void cancel(View view) {
		finish();
	}

	@SuppressWarnings("unused")
	public void register(View view) {
		String username = this.username.getText().toString();
		String fullname = this.fullname.getText().toString();
		String password = this.password.getText().toString();
		String confirm = this.confirm.getText().toString();

		try {
			UserDAO userDAO = Constants.getFactory().getUserDAO();
			if (userDAO.exist(username)) {
				AlertDialog dialog = new AlertDialog.Builder(this).create();
				dialog.setTitle("Warning");
				dialog.setMessage("Username already exists");
				dialog.setButton(AlertDialog.BUTTON_NEUTRAL, getResources()
						.getString(R.string.ok),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
							}
						});
				dialog.show();

				return;
			}
			if (password.length() == 0) {
				AlertDialog dialog = new AlertDialog.Builder(this).create();
				dialog.setTitle("Warning");
				dialog.setMessage("Password is to short");
				dialog.setButton(AlertDialog.BUTTON_NEUTRAL, getResources()
						.getString(R.string.ok),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
							}
						});
				dialog.show();
				return;
			}
			if (!password.equals(confirm)) {
				AlertDialog dialog = new AlertDialog.Builder(this).create();
				dialog.setTitle("Warning");
				dialog.setMessage("Passwords is not match");
				dialog.setButton(AlertDialog.BUTTON_NEUTRAL, getResources()
						.getString(R.string.ok),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
							}
						});
				dialog.show();
				return;
			}
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			userDAO.persist(user);
			openMainActivity(user);
			finish();
		} catch (PersistanceException e) {
			LOG.severe(e.getMessage());
			// TODO: show message
		}
	}

}
