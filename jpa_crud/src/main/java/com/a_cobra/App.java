package com.a_cobra;

import com.a_cobra.controllers.UserController;
import com.a_cobra.models.User;

public class App {
    public static void main(String[] args) {
        UserController userController = new UserController();
        User user = new User(
                null,
                "User3",
                "LastName3",
                "111111111",
                "user3@gmail.com",
                "myWeakPass");
        System.out.println("Hello World!");
        System.out.println("Saving user");
        System.out.println(user);
        userController.createUser(user);
    }
}
