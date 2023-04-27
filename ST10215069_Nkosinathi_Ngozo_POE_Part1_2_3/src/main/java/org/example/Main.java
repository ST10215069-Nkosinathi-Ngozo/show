package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main extends JDialog {

    private static JLabel nameLabel;
    static JTextField nameText;
    private static JLabel surnameLabel;
    static JTextField surnameText;
    private static JLabel userLabel;
    static JTextField userText;
    private static JLabel passwordLabel;
    static JPasswordField passwordText;
    static JFrame frame = new JFrame();// call for JFrame;

    public static void main(String[] args) {

        JPanel panel = new JPanel();// call for JPanel

        frame.setBounds( 585,300,330, 270);// sets size of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Sets the operation that will by default when the user initiates a "close" on this frame
        panel.setBackground(new Color(0, 215, 255, 255));

        frame.add(panel);// adds JPanel to the JFrame

        panel.setLayout(null);

        nameLabel = new JLabel("Name");// JLabel for name and size
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);// adds Label to panel

        nameText = new JTextField(); // text field for name where details asked for will be written
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);// adds the text field to panel

        surnameLabel = new JLabel("Surname");// JLabel for surname and size
        surnameLabel.setBounds(10, 50, 80, 25);
        panel.add(surnameLabel);// adds Label to panel

        surnameText = new JTextField();// text field for surname where details asked for will be written
        surnameText.setBounds(100, 50, 165, 25);
        panel.add(surnameText);// adds the text field to panel

        userLabel = new JLabel("Username");// JLabel for username and size
        userLabel.setBounds(10, 80, 80, 25);
        panel.add(userLabel);// adds Label to panel

        userText = new JTextField();// text field for username where details asked for will be written
        userText.setBounds(100, 80, 165, 25);
        panel.add(userText);// adds the text field to panel

        passwordLabel = new JLabel("password");// JLabel for password and size
        passwordLabel.setBounds(10, 110, 80, 25);
        panel.add(passwordLabel);// adds Label to panel

        passwordText = new JPasswordField();// text field for password where details asked for will be written
        passwordText.setBounds(100, 110, 165, 25);
        panel.add(passwordText);// adds the text field to panel

        JButton rButton = new JButton("Register");// JButton for registration and size
        rButton.setBounds(10, 150, 140, 25);
        panel.add(rButton);// adds button to panel

        JButton lButton = new JButton("Login");// JButton for Login and size
        lButton.setBounds(160, 150, 140, 25);
        panel.add(lButton);// adds button to panel

        JButton cancelButton = new JButton("Cancel");// JButton for cancel and size
        cancelButton.setBounds(85, 190, 140, 25);
        panel.add(cancelButton);// adds button to panel

        frame.setVisible(true);// sets frame and its components to become visible

        rButton.addActionListener(new ActionListener() {// sets the register button to be responsive when pressed

            @Override
            public void actionPerformed(ActionEvent e) {
                // Declarations to get information from the various text fields
                String UserName = userText.getText();
                String password = passwordText.getText();
                String name = nameText.getText();
                String surname = surnameText.getText();

                if((UserName.length() <= 5) && (UserName.contains("_"))&& (password.length() >= 8) && isValidPassword(password)){
                    try {//try, catch field used for setting up a text file database
                        FileOutputStream file = new FileOutputStream("Database.txt", true);// creates an output stream to write to a file
                        PrintWriter printWriter = new PrintWriter(file);// writes to the file of the output stream
                        printWriter.println(name + "," + surname + "," + UserName + "," + password);// writes and saves the name,surname,username and password to the file
                        printWriter.close();// the stream is closed

                    } catch (Exception ex) {// exception indicates conditions that are reasonable might want to catch

                    }
                }
                // calls methods within this class
                enterUsername(UserName);
                enterPassword(password);
                //authentication(UserName, password, name, surname);

                Login login = new Login();// calls the login classes various methods
                login.checkUserName(UserName);
                login.checkPasswordComplexity(password);
                login.registerUser(UserName, password);
            }

        });// closes of button

        lButton.addActionListener(new ActionListener() {//sets the "login" button to be responsive when pressed

            @Override
            public void actionPerformed(ActionEvent e) {
                Login l = new Login();// calls the login class(frame) for already registered users
                l.lFrame.setVisible(true);// makes the GUI in login
                frame.dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {// sets the "cancel" button to be responsive
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);// closes the GUI when pressed
            }
        });
    }

    public static boolean isValidPassword (String password) {// method for regular expression usage(regex)

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
    public static String enterUsername(String UserName) {//username method checking if conditions are met

        if ((UserName.length() <= 5) && (UserName.contains("_"))) {// conditions that should be met for the username
            JOptionPane.showMessageDialog(null, "Username successfully captured");// returns this message if username is longer than 5 letters and contains an underscore

        } else {// else statement for when conditions are not met
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, "
                    + "please ensure that your username contains an underscore and is no more than 5 characters in length");//returns this message if conditions are not met
        }
        return UserName;

    }
    public static String enterPassword(String password){// method checking if password conditions are met or not
        if ((password.length() >= 8) && isValidPassword(password)) {
            JOptionPane.showMessageDialog(null, "Password successfully captured");//returns this message if password is longer than 7 letters and contains at
            // at least 1 capital letter,
            // a number and a special character
        } else {// else statement for when conditions are not met
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted,please ensure that the password contains at least 8 characters, "
                    + "a capital letter, a number and a special character.");

        }// if conditions are not met this message is returned
        return password;
    }

}