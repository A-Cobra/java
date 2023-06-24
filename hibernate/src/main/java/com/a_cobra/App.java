package com.a_cobra;

import java.util.Optional;

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

        // Removing User works fine
        // long id = 5;
        // System.out.println(
        // userController.removeUser(id) ? "User with id " + id + " successfully
        // removed" : "Failure in removal");

        // User update works fine
        // User userToUpdate = new User(
        // 3L,
        // "USER3",
        // "LastName3",
        // "444444444",
        // "user3@gmail.com",
        // "myWeakPass3!");
        // Boolean userIsUpdated = userController.updateUser(userToUpdate);
        // System.out.println(
        // userIsUpdated ? "User with id " + userToUpdate.getId() + " successfully
        // updated"
        // : "Failure in update");

        // Single user by id works fine
        Optional<User> existingUser = userController.getUSerById(1);
        if (existingUser.isPresent()) {
            System.out.println(existingUser.get());
        } else {
            System.out.println("User not found");
        }
    }
}
