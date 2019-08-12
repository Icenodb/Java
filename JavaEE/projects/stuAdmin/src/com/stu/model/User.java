package com.stu.model;

public class User {
    private String name;
    private String psw;
    private int id;
   public User(String name,String psw)
   {
    this.name=name;
    this.psw=psw;
   }
    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

}
