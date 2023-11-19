package br.com.project.moonlight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.project.moonlight.utils.AlertDialog;
import br.com.project.moonlight.utils.EnumElements;
import br.com.project.moonlight.utils.Validate;
import br.com.project.moonlight.database.DAO;


public class LoginActivity extends AppCompatActivity {

    private TextView textEmail;
    private TextView textPassword;
    private ImageView btnContinuar;
    private AppCompatButton btnCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initElements();

        btnCadastrar.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        });


        btnContinuar.setOnClickListener(view ->{
                if(Validate.validateLogin(textEmail.getText().toString().trim().toLowerCase(),textPassword.getText().toString().trim())){
                loginUser(textEmail.getText().toString().trim().toLowerCase(),textPassword.getText().toString().trim(),
                LoginActivity.this);
                }else{
                    new AlertDialog().alertDialog(this, EnumElements.MSG_VALUES_NULL);
                }
        });
    }

    private void initElements(){
        textEmail = findViewById(R.id.editTextEmail);
        textPassword = findViewById(R.id.editTextPass);
        btnContinuar = findViewById(R.id.imageBtnContinue);
        btnCadastrar = findViewById(R.id.button_newUser);
    }

    public void  loginUser(String email, String password, Activity activity){

        DAO.conectioAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(activity, task -> {
            if (task.isSuccessful()) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                new AlertDialog().alertDialog(this, EnumElements.MSG_CREDENC_INVALID);
            }
        });

    }


}