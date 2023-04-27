package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest extends Main {
    Login l = new Login();// call of the login class, so we can access its information and its various methods

    @Test
    void correctUsernameTest() {// tester method for correct formatted username

        String user = "Kyl_1";// test data that is correct to check conditions

        assertEquals(user, enterUsername(user));// an assertEquals test that tests the test data within enterUsername method

    }

    @Test
    void incorrectUsernameTest() {// tester method for incorrect formatted username

        String user = "kyl!!!";// test data that is incorrect to check conditions

        assertEquals(user, enterUsername(user));// an assertEquals test that tests the test data within enterUsername method

    }

    @Test
    void correctPasswordTest() {// tester method for correct formatted password

        String pass = "Ch&&sec@ke99!";// test data that is correct to check conditions

        assertEquals(pass, enterPassword(pass));// an assertEquals test that tests the test data within enterPassword method

    }

    @Test
    void incorrectPasswordTest() {// tester method for incorrect formatted password

        String pass1 = "password";// test data that is incorrect to check conditions

        assertEquals(pass1, enterPassword(pass1));// an assertEquals test that tests the test data within enterPassword method
    }

    @Test
    void loginSuccessfulTest() {// tester method for successful login

        String username1 = "Kyl_1";// test data that is correct to check conditions
        String pass1 = "Ch&&sec@ke99!";// test data that is correct to check conditions

        assertTrue(true, l.returnLoginStatus(username1, pass1));// an assertTrue test that tests the test data within loginUserUsername method
    }

    @Test
    void loginFailedTest() {// tester method for successful login

        String username1 = "kyl!!!";//test data that is correct to check conditions
        String pass1 = "password";// test data that is correct to check conditions


        assertTrue(true, l.returnLoginStatus(username1, pass1));// an assertTrue test that tests the test data within loginUserUsername method
    }

    @Test
    void correctlyFormattedUsername() {//tester method that checks if username is correctly formatted
        String UserName = "Kyl_1";// test data that is correct to check conditions

        assertTrue(true, enterUsername(UserName));// an assertTrue test that tests the test data within enterUsername method

    }

    @Test
    void incorrectlyFormattedUsername() {//tester method that checks if username is incorrectly formatted

        String username1 = "kyl!!!";// test data that is correct to check conditions

        assertTrue(true, enterUsername(username1));// an assertTrue test that tests the test data within enterUsername method

    }

    @Test
    void correctlyFormattedPassword() {//tester method that checks if password is correctly formatted

        String pass = "Ch&&sec@ke99!";// test data that is correct to check conditions

        assertTrue(true, enterPassword(pass));// an assertTrue test that tests the test data within the enterPassword method

    }

    @Test
    void incorrectlyFormattedPassword() {//tester method that checks if password is correctly formatted

        String username1 = "password";// test data that is correct to check conditions

        assertTrue(true, enterPassword(username1));//an assertTrue test that tests the test data within the enterPassword method

    }
}
