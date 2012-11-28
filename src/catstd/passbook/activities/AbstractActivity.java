package catstd.passbook.activities;

import catstd.passbook.Constants;
import catstd.passbook.dao.dto.User;
import catstd.passbook.utils.Assembler;
import android.app.Activity;
import android.content.Intent;

public abstract class AbstractActivity extends Activity {

	public void openLoginActivity() {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}

	public void openRegistrationActivity() {
		Intent intent = new Intent(this, RegistrationActivity.class);
		startActivity(intent);
	}

	public void openMainActivity(User user) {

		Intent intent = new Intent(this, MainActivity.class);
		intent.putExtra(Constants.EXTRA_USER, Assembler.assemble(user));
		startActivity(intent);
	}

}