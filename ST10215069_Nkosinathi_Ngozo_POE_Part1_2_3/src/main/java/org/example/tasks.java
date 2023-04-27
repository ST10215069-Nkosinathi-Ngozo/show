package org.example;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class tasks extends Main {

    String taskDescription;
    String developerDetails;
    String taskID;
    String taskStatusOutput;

    Random random = new Random();
    int duration= random.nextInt(23) + 1;

    public boolean checkTaskDescription(String taskDescription){
        if(taskDescription.length()> 50){
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than \n" +
                    "50 characters");
            return false;
        }
        else {
            return true;
        }
    }
    public void returnTaskDescription(){
        do{
            taskDescription = JOptionPane.showInputDialog("Enter task description");// prompts user to enter a task description
        }while(!checkTaskDescription(taskDescription));
        JOptionPane.showMessageDialog(null, "Task successfully captured");// if task description is less than 50 characters this message is returned
    }

    public String checkTaskID(String name, String surname, int taskNumber, String taskName){
        developerDetails = name + " " +surname;
        String devDetailsSubstring = name.substring(name.length()-3);// creates the substring of the last 3 letters of the developers name
        String taskNameSubstring = taskName.substring(0,2);// creates a substring of the first two letters of the task name
        return taskID = taskNameSubstring.toUpperCase() + ":" + taskNumber + ":" + devDetailsSubstring.toUpperCase(); // The task id is returned consisting of the substrings and task number
    }

    public void taskStatus(){

        int taskStatus = Integer.parseInt(JOptionPane.showInputDialog("""
                Choose between these options for task status
                Option 1: To Do
                Option 2: Done
                Option 3: Doing"""));// Message that prompts user to choose different options for the task status

        switch (taskStatus) {// case that allows the user to choose the task status
            case 1 -> taskStatusOutput = "To Do";
            case 2 -> taskStatusOutput = "Done";
            case 3 -> taskStatusOutput = "Doing";
        }
    }
    public String printTaskDetails(int taskNumber, String taskName) {// method that returns the task details
        taskStatus();// calls the taskStatus method
        JOptionPane.showMessageDialog(null, "Task Status: " + taskStatusOutput
                + "\nDeveloper Details: " + developerDetails
                + "\nTask Number: " + taskNumber
                + "\nTask Name: " + taskName
                + "\nTask Description: " + taskDescription
                + "\nTask ID: " + taskID
                + "\nDuration: " + duration + " hrs");// prints task details
        return null;
    }

    public void taskDatabase(){// method to save the duration hours in a text file database
        try{
            File file = new File("tasksDurationDatabase.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
            pw.append("\n").append(String.valueOf(duration));
            pw.close();
        } catch (Exception ex) {// exception indicates conditions that are reasonable might want to catch

        }
    }
    public int accumulateTotalHours() {
        int totalDuration = 0;
        try {// Try, catch block to access the text file database written when registering
            File files = new File("tasksDurationDatabase.txt"); // gives us the file pth so we can access it
            Scanner scan = new Scanner(files);// scanner used to scan the text file snd its contents

            while (scan.hasNextInt()) {//.hasNext() returns true if this scanner has another token in its input
                // scans the text file database in this order inorder for us to access the information we want to access
                totalDuration += scan.nextInt();//calculates total of saved data
            }
            JOptionPane.showMessageDialog(null, "The total duration " + totalDuration + "hrs");
        } catch (Exception evt) {// catch for when there is an exception error
            JOptionPane.showMessageDialog(null, "an error occurred " + evt,"Error",JOptionPane.ERROR_MESSAGE);// message displayed when error occurs
        }
        return totalDuration;// returns total
    }
    public int returnTotalHours(){

        int []hours = new int []{10,12,55,11,1};

        int totalHours= 0;
        for (int hour : hours) {
            totalHours += hour;
        }
        JOptionPane.showMessageDialog(null, totalHours);
        return totalHours;
    }
}

