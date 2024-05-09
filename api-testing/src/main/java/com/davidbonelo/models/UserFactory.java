package com.davidbonelo.models;

public class UserFactory {
    // This would get a user from a database or the admin api
    public static User getRegisteredUser() {
        return new User(3, "emma.wong@reqres.in", "Emma", "Wong", "https://reqres" +
                ".in/img/faces/3-image.jpg", "ultraSecretPassword");
    }

}
