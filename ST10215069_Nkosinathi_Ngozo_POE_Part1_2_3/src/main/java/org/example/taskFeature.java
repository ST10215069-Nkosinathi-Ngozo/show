package org.example;

import javax.swing.*;

public class taskFeature {
    //Declaration of variables that will be global within this class
    int numberOfTasks;
    int task;// declaration of variable to choose a task from option
    int taskNumber; // variable for iteration of the auto generated task number
    String taskName;

    public void selectionLoops(String name, String surname) {// Method specific for the various loops used within this program
        while (task != 3){// A loop that iterates the tasks from 0 and above as long as the program keeps running
            selectionOfTask(name, surname);// Calls the method that will run everything within the tasks features
        }

    }
    public void selectionOfTask(String name, String surname) {

        task = Integer.parseInt(JOptionPane.showInputDialog(
                """
                        Choose between these options
                        Option 1: Add tasks
                        Option 2: Show report
                        Option 3: Quit"""));// Prompts user to select from given options

        switch (task) {//Switch/case for user to choose from
            case 1 -> {
                JOptionPane.showMessageDialog(null, "Add tasks");
                numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tasks you " +
                        "wish to start the application"));// for input of number of task boards
                taskInformation(name, surname);//first cases rubs code for dorm yhe user fills in
            }
            case 2 -> {
                //JOptionPane.showMessageDialog(null, "Coming Soon");// second case just says coming as feature will still be implemented
                storeData sd = new storeData();
                sd.detailLoop();
            }
        }
    }
    public void taskName(){

        taskName = JOptionPane.showInputDialog("Enter task name: ");// Method asking for task name

    }
    public void taskInformation(String name, String surname) {
        for (taskNumber = 0; taskNumber < numberOfTasks; taskNumber++){// A for loop that will iterate the tasks for the set number of times selected when asked the number of tasks and increment the task number
            // A method that calls the methods within the tasks class
            taskName();
            tasks t = new tasks();
            t.returnTaskDescription();
            t.checkTaskID(name, surname, taskNumber, taskName);
            t.printTaskDetails(taskNumber, taskName);
            t.taskDatabase();
        }
        tasks t = new tasks();// calls the tasks class again after everything has been run
        t.accumulateTotalHours();// calls the method that calculates the total hours P.S keep pressing ok/enter and the last value is the correct value
    }
}
