package com.qa.testData;

public class DataHolder {
   public static  String firstName;
     public static String lastName;

    public static String getFirstName() {
        return firstName;
    }
    public static void setFirstName(String firstName) {
        DataHolder.firstName = firstName;
    }
    public static String getLastName() {
        return lastName;
    }
    public static void setLastName(String lastName) {
        DataHolder.lastName = lastName;
    }
}
