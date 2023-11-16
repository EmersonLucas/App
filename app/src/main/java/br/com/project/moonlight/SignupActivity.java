package br.com.project.moonlight;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import br.com.project.moonlight.database.DAO;
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

          if (Validate.validateRegister(textName.getText().toString().trim(), textEmail.getText().toString().trim().toLowerCase(), textPassword.getText().toString().trim())){
              if (Validate.validateEmail(textEmail.getText().toString().trim().toLowerCase())){
                  AlertDialog.showCustomDialogAlert(EnumElements.MSG_EMAIL_INVALID.toString(), this);
                  return;
              }
              if (!Validate.validatePassword(textPassword.getText().toString().trim())) {
                  AlertDialog.showCustomDialogAlert(EnumElements.MSG_PASS_INVALID.toString(), this);
                  return;
              }

              try {
                  User user = new User(textName.getText().toString().trim(),
                          textEmail.getText().toString().trim().toLowerCase(),
                          textPassword.getText().toString().trim());
                  DAO.registerNewUser(user);
              }catch(Exception e){
                  AlertDialog.showCustomDialogAlert(EnumElements.MSG_EMAIL_USED.toString(), this);
                  return;
              }
              AlertDialog.showCustomDialogAlertNewView(
                      EnumElements.MSG_REGISTER_SUCCESSFUL.toString(),
                      this,
                      MainActivity.class,
                      EnumElements.MSG_REGISTER_SUCCESSFUL);
          }
          else AlertDialog.showCustomDialogAlert(EnumElements.MSG_VALUES_NULL.toString(), this);;
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
