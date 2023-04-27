package org.example;

import javax.swing.*;

public class storeData {//A class that is used to store the arrays of users

    String[] developerDetails = new String[]{"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};//This array is used to store the developers details

    String[] taskID = new String[]{"CR:1:IKE", "CR:2:ARD", "CR:3:THA", "AD:4:NDA"};//This array is used to store the developers task ID

    String[] taskName = new String[]{"Create Login", "Create Add Features",
            "Create Reports", "Add Arrays"};//This array is used to store the task's name

    int[] taskDuration = new int[]{ 5, 8, 2, 11};//This array stores the tasks' duration using a primitive datatype of integer instead of int as it

    String[] taskStatus = new String[]{"To Do", "Doing", "Done", "To Do"};//This array stores task's status

    String accessData;
    readData rd = new readData();

    public void detailLoop() {// A method that
        do {
            accessData();// calls the access data method which will give the user the information they wish to access in arrays
        }
        while (!accessData.equals("z"));// A do-while loop is implemented so the code continues running until z is entered
    }
    public void accessData() {

        accessData = JOptionPane.showInputDialog("""
                Enter letter of information you wish to access
                a) Display developers
                b) Display done developers
                c) Display developer with longest duration
                d) search for specific task
                e) search developer
                f) Delete task
                g) Display Report
                z) QUIT""");// a message that prompts the user to enter the letter of information they wish to access

        switch (accessData) {// A switch/case to choose what which action to perform

            case "a" -> rd.developerData(developerDetails);
            case "b" -> rd.viewDoneDevelopers(taskStatus,developerDetails,taskDuration, taskName);
            case "c" -> rd.longestDuration(taskDuration, developerDetails);
            case "d" -> rd.searchSpecificTask(taskName, developerDetails);
            case "e" -> rd.searchAllTasks(taskName, developerDetails);
            case "f" -> rd.deleteTask(taskName);
            case "g" -> rd.displayDetails(developerDetails,taskName,taskID,taskDuration,taskStatus);
        }
    }
}


