package com.example.leo_i019213.appemas.Models;


public class Favorites {

    private long id;
    private long idUser;
    private long idBus;
    private  boolean check =false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdBus() {
        return idBus;
    }

    public void setIdBus(long idBus) {
        this.idBus = idBus;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
