package br.com.project.moonlight.utils;

public class Validate {


   public static boolean validateRegister(String nome, String email, String password){

       return !nome.isEmpty() && !email.isEmpty() && !password.isEmpty();
   }

    public static boolean validateLogin(String email, String password){

        return !email.isEmpty() && !password.isEmpty();
    }

    public static boolean validatePassword(String password){

        return password.length() >= 6;
    }

    public static boolean validateEmail(String email){

        return !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}
