package com.example.csc325_firebase_webview_auth.model;

public class CurrUser {
    private static String uid;
    private static String username;
    private static String password;

    public static void setCurrentUser(User user) {
        uid = user.getUid();
    }

    public static String getUid() {
        return uid;
    }
}
