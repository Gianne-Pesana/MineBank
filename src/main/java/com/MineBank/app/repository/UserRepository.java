/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.repository;

import com.MineBank.app.UserAccStatus;
import java.util.ArrayList;
import com.MineBank.app.model.User;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author giann
 */
public class UserRepository {
    private static String filepath;

    public UserRepository(String filepath) {
        this.filepath = filepath;
    }
    
    

    public ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();
        
        try (Scanner inFile = new Scanner(new FileReader(this.filepath))) {
            String line; 
            while(inFile.hasNextLine()) {
                line = inFile.nextLine().trim();
                users.add(parseCSV(line));
            }
        } catch (IOException e) {
            System.out.println("Error in loading users:");
            System.out.println(e.getMessage());
        }
        
        return users;
    }
    
    private User parseCSV(String line) {
        String parts[] = line.split("\\|");
        if(parts.length != 9) {
            System.out.println("Error in parsing data.");
            return null;
        }
        
        return new User(
                parts[0],   // Acc Num
                parts[1],   // username
                parts[2],   // password
                parts[3],   // first name
                parts[4],   // last name
                Integer.parseInt(parts[5]),     // age
                Double.parseDouble(parts[6]),   // balance
                UserAccStatus.valueOf(parts[7]),// status
                parts[8]    // profile image
        );
    }
    
    public User findUsername(String username) {
        for (User user : loadUsers()) {
            if(username.equalsIgnoreCase(user.getUsername()))
                return user;
        }
        
        return null;
    }
    
}
