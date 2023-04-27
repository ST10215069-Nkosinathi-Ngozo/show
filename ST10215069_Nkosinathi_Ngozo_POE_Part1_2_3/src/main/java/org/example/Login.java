package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends JDialog {

    JLabel LUserLabel;
    JTextField LUserText;
    JLabel LPassLabel;
    JPasswordField LPassText;
    JButton lButton2,rButton2,cancelButton2;
    JFrame lFrame = new JFrame();
    String message;
    boolean value;
    public Login() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 215, 255, 255));
        lFrame.setBounds(585, 300, 330, 270);// sets size of frame
        lFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lFrame.add(panel);

        panel.setLayout(null);

        LUserLabel = new JLabel("Username");
        LUserLabel.setBounds(10, 20, 80, 25);
        panel.add(LUserLabel);

        LUserText = new JTextField();
        LUserText.setBounds(100, 20, 165, 25);
        panel.add(LUserText);

        LPassLabel = new JLabel("Password");
        LPassLabel.setBounds(10, 50, 80, 25);
        panel.add(LPassLabel);

        LPassText = new JPasswordField();
        LPassText.setBounds(100, 50, 165, 25);
        panel.add(LPassText);

        lButton2 = new JButton("Sign in");
        lButton2.setBounds(10, 150, 140, 25);
        panel.add(lButton2);

        rButton2 = new JButton("Register");
        rButton2.setBounds(160, 150, 140, 25);
        panel.add(rButton2);

        cancelButton2 = new JButton("Cancel");
        cancelButton2.setBounds(85, 190, 140, 25);
        panel.add(cancelButton2);

        lButton2.addActionListener(new ActionListener() {// responsive actions for when the login button is pressed

            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameL = LUserText.getText();
                String passwordL = LPassText.getText();
                message = "invalid";
                try {// Try, catch block to access the text file database written when registering
                    File files = new File("Database.txt"); // gives us the file pth so we can access it
                    Scanner scan = new Scanner(files);// scanner used to scan the text file snd its contents
                    scan.useDelimiter("[,\n]"); //sets the scanners delimiting pattern which reads the commas within the database

                    while (scan.hasNext()) {//.hasNext() returns true if this scanner has another token in its input
                        // scans the text file database in this order inorder for us to access the information we want to access
                        String name = scan.next();
                        String surname = scan.next();
                        String UserName = scan.next();
                        String password = scan.next();

                        if ((usernameL.equals(UserName.trim())) && (passwordL.equals(password.trim()))) {//checks if conditions are met. .trim() is stop the scanner because it creates a space after information which we don't want
                            message = "Logged in";// displays this message if conditions are met
                        }
                    }
                    JOptionPane.showMessageDialog(null, message);
                    loginUser(usernameL, passwordL);//methods called
                    returnLoginStatus(usernameL, passwordL);
                    authentication(usernameL, passwordL);
                } catch (Exception evt) {// catch for when there is an exception error
                    JOptionPane.showMessageDialog(null, "an error occurred " + evt,"Error",JOptionPane.ERROR_MESSAGE);// message displayed when error occurs
                }
            }
        });
        rButton2.addActionListener(new ActionListener() {// responsive actions for when the login button is pressed
            @Override
            public void actionPerformed(ActionEvent e) {
                //Main m = new Main();//calls the main method
                Main.frame.setVisible(true);// sets its JFrame visible
                lFrame.dispose();
            }
        });
        cancelButton2.addActionListener(new ActionListener() {// responsive actions for when the cancel button is pressed
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);// exits or closes program when pressed

            }
        });
    }
    public boolean isValidPassword(String password) {// method for regular expression usage(regex)
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[!@#$%^&*+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);//the regex is compiled in Pattern

        if (password == null)
            return false;

        Matcher m = p.matcher(password);// checks if given password is matching the given restrictions to be followed
        return m.matches();
    }

    public boolean checkUserName(String UserName) {//method that returns true or false depending on whether the username contains an underscore or not
        if (UserName.contains("_")){
            System.out.println("return: " + true);
            return true;
        }else {
            System.out.println("return: " + false);
            return false;
        }
    }

    public boolean checkPasswordComplexity(String password ) {//method that returns true or false depending on whether password contains  a special character, digit, capital letter and at least 8 characters or not
        if(isValidPassword(password) && password.length()>=8) {
            System.out.println("return: " + true);
            return true;
        }else {
            System.out.println("return: " + false);
            return false;
        }
    }

    public void registerUser(String UserName, String password) {
        if ((UserName.length() <= 5) && (UserName.contains("_") && (password.length() >= 8) && isValidPassword(password))){
            JOptionPane.showMessageDialog(null, "Registration complete. Welcome"); // returns if the username and password information has been authenticated
            lFrame.setVisible(true);// sets the frame visible
            Main m = new Main();
            m.frame.dispose();
        }else {
            JOptionPane.showMessageDialog(null, "Registration Username or password incorrect, please try again");
        }
    }
    public void loginUser(String usernameL,String passwordL){// method checking if login details are correct or not
        value = false;
        try {
            File files = new File("Database.txt");
            Scanner scan = new Scanner(files);
            scan.useDelimiter("[,\n]");

            while (scan.hasNext()) {
                String name= scan.next();
                String surname= scan.next();
                String UserName = scan.next();
                String password= scan.next();


                if ((usernameL.equals(UserName.trim())) && (passwordL.equals(password.trim()))){
                    value = true;
                }
            }
            System.out.println("return: " + value);
        } catch (Exception evt) {
            JOptionPane.showMessageDialog(null, "an error occurred " + evt);
        }
    }
    public  String returnLoginStatus( String usernameL, String passwordL) {
        message = "A failed login";
        String name = null;
        String surname = null;
        //method returning login status depending on the conditions
        try {// Try, catch block to access the text file database written when registering
            File files = new File("Database.txt"); // gives us the file pth so we can access it
            Scanner scan = new Scanner(files);// scanner used to scan the text file snd its contents
            scan.useDelimiter("[,\n]"); //sets the scanners delimiting pattern which reads the commas within the database

            while (scan.hasNext()) {//.hasNext() returns true if this scanner has another token in its input
                // scans the text file database in this order inorder for us to access the information we want to access
                name = scan.next();
                surname = scan.next();
                String UserName = scan.next();
                String password = scan.next();


                if ((usernameL.equals(UserName.trim())) && (passwordL.equals(password.trim()))) {//checks if conditions are met. .trim() is stop the scanner because it creates a space after information which we don't want displays this message if conditions are met
                    message = "A successful Login";
                }
            }
            JOptionPane.showMessageDialog(null, message);

        } catch (Exception evt) {// catch for when there is an exception error
            JOptionPane.showMessageDialog(null, "an error occurred " + evt);// message displayed when error occurs
        }
        return message;
    }
    public void authentication(String usernameL,String passwordL) {
        String message ="Username or password incorrect, please try again";
        String name = null;
        String surname = null;

        try {// Try, catch block to access the text file database written when registering
            File files = new File("Database.txt"); // gives us the file pth so we can access it
            Scanner scan = new Scanner(files);// scanner used to scan the text file snd its contents
            scan.useDelimiter("[,\n]"); //sets the scanners delimiting pattern which reads the commas within the database

            while (scan.hasNext()) {//.hasNext() returns true if this scanner has another token in its input
                // scans the text file database in this order inorder for us to access the information we want to access
                name = scan.next();
                surname = scan.next();
                String UserName = scan.next();
                String password = scan.next();

                if (usernameL.equals(UserName.trim()) && (passwordL.equals(password.trim()))) {
                    message="Welcome " + name + " " + surname + " it is great to see you again.";//checks the conditions of both the username and password
                }
            }
            JOptionPane.showMessageDialog(null, message);
            if (message.contains("Welcome")){
                taskFeature tf = new taskFeature();
                tf.selectionLoops(name, surname);}
        } catch (Exception evt) {// catch for when there is an exception error
            JOptionPane.showMessageDialog(null, "an error occurred " + evt);// message displayed when error occurs
        }
    }

}
