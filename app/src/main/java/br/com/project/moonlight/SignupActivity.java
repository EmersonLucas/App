package br.com.project.moonlight;


import static br.com.project.moonlight.database.DAO.registerNewUser;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import br.com.project.moonlight.model.User;
import br.com.project.moonlight.utils.AlertDialog;
import br.com.project.moonlight.utils.EnumElements;
import br.com.project.moonlight.utils.Validate;

public class SignupActivity extends AppCompatActivity {

    private ImageView btnContinuar;
    private EditText textName;
    private EditText textEmail;
    private EditText textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initElements();

        btnContinuar.setOnClickListener(view -> {

          if (Validate.validateRegister(textName.getText().toString().trim(), textEmail.getText().toString().trim().toLowerCase(),
                  textPassword.getText().toString().trim())) {
              if (Validate.validateEmail(textEmail.getText().toString().trim().toLowerCase())) {
                  new AlertDialog().alertDialog(this, EnumElements.MSG_EMAIL_INVALID);
                  return;
              }
              if (!Validate.validatePassword(textPassword.getText().toString().trim())) {
                  new AlertDialog().alertDialog(this, EnumElements.MSG_PASS_INVALID);
                  return;
              }

              User user = new User(textName.getText().toString().trim(), textEmail.getText().toString().trim().toLowerCase(), textPassword.getText().toString().trim());
              registerNewUser(user, this,this);
          }else new AlertDialog().alertDialog(this, EnumElements.MSG_VALUES_NULL);
        });
    }

    private void initElements() {
        // //Inicializando Botão continuar
        btnContinuar = findViewById(R.id.button_continue_login);
        textName = findViewById(R.id.editTextNome);
        textEmail = findViewById(R.id.editTextEmailSing);
        textPassword = findViewById(R.id.editTextPassSing);
    }
}
