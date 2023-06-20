package com.a_cobra;

import java.util.List;

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
        System.out.println("Getting users");
        System.out.println(user);
        // userController.createUser(user);
        List<User> users = userController.getAllUsers();
        for (User singleUser : users) {
            System.out.println(singleUser);
        }
    }
}
