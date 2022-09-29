package com.ciclo3.TodoCompleto.Models;

public class ObjetAnswer {
    //Atributes
    private Object objetc;
    private String message;

    //Constructor
    public ObjetAnswer(String message,Object objetc ) {
        this.objetc = objetc;
        this.message = message;
    }

    //Constructor Empty
    public ObjetAnswer() {
    }

    //Setters and Getters

    public Object getObjetc() {
        return objetc;
    }

    public void setObjetc(Object objetc) {
        this.objetc = objetc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
