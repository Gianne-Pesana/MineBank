/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.model;

import com.MineBank.app.Enums.UserAccStatus;
import com.MineBank.app.utils.Utils;

/**
 *
 * @author giann
 */
public class User {
    private String accNum;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private double balance;
    private UserAccStatus status;
    private String profileImage;

    public User(String accNum, String username, String password, String firstName, String lastName, int age, double balance, UserAccStatus status) {
        this.accNum = accNum;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.balance = balance;
        this.status = status;
        this.profileImage = "/icons/profile/Villager-Default3-90px.png";
    }

    public User(String accNum, String username, String password, String firstName, String lastName, int age, double balance, UserAccStatus status, String profileImage) {
        this.accNum = accNum;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.balance = balance;
        this.status = status;
        this.profileImage = profileImage;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public UserAccStatus getStatus() {
        return status;
    }

    public void setStatus(UserAccStatus status) {
        this.status = status;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getFullName() {
        return Utils.toProperCase(firstName + " " + lastName);
    }
    
    
    
}
