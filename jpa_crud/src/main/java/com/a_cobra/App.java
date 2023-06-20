package com.a_cobra;

import java.util.List;

import com.a_cobra.controllers.UserController;
import com.a_cobra.models.User;

public class App {
    public static void main(String[] args) {
        UserController userController = new UserController();
        User user = new User(
                null,
                "User4",
                "LastName4",
                "222222222",
                "user4@gmail.com",
                "myWeakPass4");

        // CREATE USER WORKS
        // userController.createUser(user);

        // GETTING USERS WORKS
        // List<User> users = userController.getAllUsers();
        // for (User singleUser : users) {
        // System.out.println(singleUser);
        // }
    }
}
