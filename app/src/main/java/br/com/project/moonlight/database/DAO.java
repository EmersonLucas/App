package br.com.project.moonlight.database;



import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import br.com.project.moonlight.LoginActivity;
import br.com.project.moonlight.model.User;

public class DAO {

    private static FirebaseAuth auth;
    public static final FirebaseAuth conectioAuth = DAO.firebaseAuth();

    private static FirebaseAuth firebaseAuth(){

       if(auth == null) auth = FirebaseAuth.getInstance();

    return auth;
    }

    public static void registerNewUser(User user){
        conectioAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword());
    }


}
