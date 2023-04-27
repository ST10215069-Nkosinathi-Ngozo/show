package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class readData {

    public String[] developerData(String[]developerDetails) {//A class for String arrays

        for(String developerDetail: developerDetails){// A for-each loop that defines i as every element within developer details array
            System.out.println(developerDetail + " ");// prints every element of i which are of the array developer details
        }
        return developerDetails;// This method returns the array of developerDetails
    }

    public String longestDuration(int []taskDuration, String[]developerDetails) {//A method that calculates the largest number within the task durations
        int longestDuration = taskDuration[0];// initialization for placeholder of the largest number as first number of the task duration array
        String returnDeveloper = null;// declaration of variable that will give the developer with the longest duration
        for(int taskDurationIndex = 0; taskDurationIndex<taskDuration.length;taskDurationIndex++){// A for-loop that will loop throughout the taskDuration
            if (taskDuration[taskDurationIndex]>longestDuration) {// an if statement that checks if there is a larger number than the assigned largest number
                longestDuration = taskDuration[taskDurationIndex];//if there is a larger number than the 'largest it is therefore assigned as the new largest number
                returnDeveloper = developerDetails[taskDurationIndex] + ", " + longestDuration;// assignment of declared variable
            }
        }
        JOptionPane.showMessageDialog(null, returnDeveloper);//Display of developer
        return returnDeveloper;// returns the declared returnDeveloper
    }

    public String searchSpecificTask(String []taskName, String[]developerDetails) {
        String searchTask = JOptionPane.showInputDialog("Enter task name you want" +
                " information on");//Prompt to enter task name you want information for

        String returnStatement = "Task not found";// the return statement is initialized as null at first
        for (int taskNameIndex = 0;taskNameIndex<taskName.length;taskNameIndex++)// A for-loop that will loop throughout the taskName array
            if(searchTask.equals(taskName[taskNameIndex] )) {// An if statement that checks if the input task matches an element in the taskName array
                returnStatement = developerDetails[taskNameIndex] + ", " + taskName[taskNameIndex];// new assignment of variable if, if statement is correct
            }
        JOptionPane.showMessageDialog(null, returnStatement);
        return returnStatement;
    }

    public String searchAllTasks(String []taskName, String[]developerDetails){
        String developer = JOptionPane.showInputDialog("Enter developer name you want information on");
        String returnTaskName = "Developer not found";// message assigned wrong
        for (int developerIndex = 0;developerIndex<developerDetails.length;developerIndex++)// A for-loop that will loop throughout the developer details array
            if(developer.equals(developerDetails[developerIndex])){// An if statement that checks if the inputted developer matches an element in the developerDetails array
                returnTaskName = taskName[developerIndex];// new assignment of variable if, if statement is correct
            }
        JOptionPane.showMessageDialog(null, returnTaskName );
        return returnTaskName;
    }

    public String deleteTask(String []taskName) {
        String deleteTask = JOptionPane.showInputDialog(null,"Enter task you would like to delete","Delete",JOptionPane.QUESTION_MESSAGE);
        String returnMessage = "Entry not found";
        String updatedList = "List has not been updated";
        ArrayList<String> newList;
        for (String i : taskName) {// A for-each that will loop throughout the taskName
            if (deleteTask.equals(i)) {
                newList = new ArrayList<>(Arrays.asList(taskName));// changes array into array list
                newList.remove(deleteTask);// removes the inputted array in the array
                returnMessage = "Entry \"" + deleteTask + "\" successfully deleted";// new assignment of message
                updatedList = "The new list of tasks is " + newList;// new assignment of message
            }
        }
        JOptionPane.showMessageDialog(null, returnMessage);//displays message
        JOptionPane.showMessageDialog(null, updatedList);//displays message
        return returnMessage;// returns message

    }
    public String displayDetails(String[]developerDetails,String []taskName, String []taskID, int []taskDuration, String[]taskStatus) {//A method defined as a multidimensional object array
        String report = null;
        for(int i = 0; i<developerDetails.length; i++){// A for-loop that will loop throughout the developer details
            report = developerDetails[i] + ", " + taskName[i] + ", " + taskID[i] + ", " + taskDuration[i]+ ", " + taskStatus[i];
            System.out.println(report);
        }
        return report;
    }
    public String viewDoneDevelopers(String []taskStatus, String[]developerDetails, int[]taskDuration, String[]taskName){
        String taskDone ="Done";//Variable assigned done
        String message = null;
        for(int doneDevIndex = 0;doneDevIndex<taskStatus.length;doneDevIndex++){// A for-loop that will loop throughout the taskStatus array
            if(taskDone.equals(taskStatus[doneDevIndex])){// An if statement that checks if the Keyword 'done' matches an element in the task status array
                message = developerDetails[doneDevIndex]+", "+taskName[doneDevIndex] + ", " + taskDuration[doneDevIndex];// new assignment of variable if, if statement is correct
                JOptionPane.showMessageDialog(null,message);//displays user information
            }
        }
        return message;// returns message
    }
}
/* Alex Lee(2019) Return Statement in Java [online video] Available at: https://youtu.be/L1htVG3xP5Y [Accessed 6/6/2022]
 * Bill Barnum(2021) Find The Maximum Value In A Java Array [online video] Available at: https://youtu.be/u3ZTJmioho0 [Accessed ]
 * Coding with John(2022) Java Unit Testing with Junit-Tutorial-How to Create And Use Unit Tests [online video] Available at: https://youtu.be/vZm0lHciFsQ [Accessed 29/5/2022]
 * Keep On Coding(2020) Java File I/O(Reading & Writing [online video] Available at: https://youtu.be/hgF21imQ_Is  [Accessed 6/6/2022]
 * Farrell, J. 2018. Java Programming. 9th ed, Boston: Cengage Learning.
 */
