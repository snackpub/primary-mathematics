package com.snackpub.core.moduel;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author snackpub
 * @date 2021/1/10
 */
public class User implements Serializable {

    private int id;
    private String userName;
    private String password;

    private int delFlag;
    // 流水号
    private String lsh;


    public User() {
    }

    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public User(int id, String userName, String password,String lsh) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.lsh = lsh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public String getLsh() {
        return lsh;
    }

    public void setLsh(String lsh) {
        this.lsh = lsh;
    }
}
