/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.repository;

import com.MineBank.app.Enums.UserAccStatus;
import java.util.ArrayList;
import com.MineBank.app.model.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.stream.FileCacheImageInputStream;


/**
 *
 * @author giann
 */
public class UserRepository {
    private static String filepath;
    private static String tempFilePath = "data\\transactions\\temp.txt";

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
    
    public void updateUser(User user) {
        // copy data to temp file
        try(
            BufferedReader inFile = new BufferedReader(new FileReader(filepath));
            FileWriter tempWriter = new FileWriter(tempFilePath)
        ) {
            String line;
            
            while((line = inFile.readLine()) != null) {
                tempWriter.append(line).append("\n");
            }
            
            tempWriter.close();
        } catch (IOException tempFileException) {
            System.out.println("Error: Failed to copy data to temp file.");
        }
        
            
        // writes updated data
        try(
            BufferedReader inTempFile = new BufferedReader(new FileReader(tempFilePath));
            FileWriter outFile = new FileWriter(filepath);   
        ) {
            String line;
            while((line = inTempFile.readLine()) != null) {
                String parts[] = line.split("\\|");
                
                if(parts[0].equals(user.getAccNum())) {
                    outFile.append(formatToFile(user) + "\n");
                } else {
                    outFile.append(line).append("\n");
                }
            }
            
        } catch (IOException updateFileException) {
            System.out.println("Error: Failed to update user data.");
            return;
        }
        
        // clears temp file
        new File(tempFilePath).delete();
    }
    
    private String formatToFile(User user) {
        return user.getAccNum() + "|" + user.getUsername() + "|" +
               user.getPassword() + "|" + user.getFirstName() + "|" +
               user.getLastName() + "|" + user.getAge() + "|" +
               user.getBalance() + "|" + user.getStatus() + "|" +
               user.getProfileImage();
    }
}
