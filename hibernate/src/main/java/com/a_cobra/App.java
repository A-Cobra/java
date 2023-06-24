package com.a_cobra;

import com.a_cobra.controllers.UserController;
import com.a_cobra.models.User;

public class App {
    private static final UserController userController = new UserController();

    public static void main(String[] args) {
        // User creation works fine
        // User createdUser = userController.createUser(
        // "User4",
        // "LastName4",
        // "444444444",
        // "user4@gmail.com",
        // "myWeakPass3");
    }
}
