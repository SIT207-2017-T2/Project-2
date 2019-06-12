package darkeung.example.com.sit207ass2nchu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEditText = (EditText) findViewById(R.id.email);
        passEditText = (EditText) findViewById(R.id.password);
        Button btn1 = (Button) findViewById(R.id.btnGoHome);

        findViewById(R.id.btnGoHome).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                final String email = emailEditText.getText().toString();
                final String pass = passEditText.getText().toString();
                if (!isValidEmail(email)) {
                    emailEditText.setError("Invalid Email");
                } else if (!isValidPassword(pass)) {
                    passEditText.setError("Invalid Password");
                } else {
                    Intent intent = new Intent(Login.this, HomeActivity.class);
                    startActivity(intent);

                }


            }
        });


    }





    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }
}