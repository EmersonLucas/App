package br.com.project.moonlight.database;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;
import br.com.project.moonlight.MainActivity;
import br.com.project.moonlight.model.User;
import br.com.project.moonlight.utils.AlertDialog;
import br.com.project.moonlight.utils.EnumElements;

public class DAO {
    private static FirebaseAuth auth;

    private static Context contextG;
    private static Activity activityG;
    public static final FirebaseAuth conectioAuth = DAO.firebaseAuth();
    private static FirebaseAuth firebaseAuth(){

       if(auth == null) auth = FirebaseAuth.getInstance();

    return auth;
    }

    public static void registerNewUser(@NonNull User user, Context context, Activity activity) {

        contextG = context;
        activityG = activity;

        conectioAuth.getInstance().fetchSignInMethodsForEmail(user.getEmail())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        SignInMethodQueryResult result = task.getResult();
                        if (result != null && result.getSignInMethods() != null && !result.getSignInMethods().isEmpty()) {
                            Log.d("DAO", "Email já cadastrado");
                            handleEmailUsed();
                        } else {
                            Log.d("DAO", "Email não cadastrado, criar usuário");
                            createFirebaseUser(user);
                        }
                    } else {
                        Log.d("DAO", "Erro ao verificar o e-mail");
                        handleConnectionFailure();
                    }
                });
    }

    private static void createFirebaseUser(User user) {
        conectioAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Usuário criado com sucesso
                        handleRegistrationSuccess();
                    } else {
                        // Falha ao criar usuário
                        handleRegistrationFailure();
                    }
                });
    }

    // Métodos para lidar com os resultados
    private static void handleEmailUsed() {
        new AlertDialog().alertDialog(contextG, EnumElements.MSG_EMAIL_USED);
    }

    private static void handleConnectionFailure() {
        new AlertDialog().alertDialogErro(contextG, EnumElements.MSG_FAILED_CONECTION);
    }

    private static void handleRegistrationSuccess() {
        new AlertDialog().alertDialogOk(contextG, EnumElements.MSG_REGISTER_SUCCESSFUL,  activityG);
    }

    private static void handleRegistrationFailure() {
        new AlertDialog().alertDialog(contextG, EnumElements.MSG_EMAIL_USED);
    }

}
