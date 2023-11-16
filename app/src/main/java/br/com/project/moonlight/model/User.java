package br.com.project.moonlight.model;

import java.util.List;


public class User {

    private String name;
    private String email;
    private String password;
    private String numberphone;
    private String CPF;

    public List<PublicRom> myPublics;


    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        new PublicRom();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public List<PublicRom> getMyPublics() {
        return myPublics;
    }

    public void setMyPublics(List<PublicRom> myPublics) {
        this.myPublics = myPublics;
    }
}
