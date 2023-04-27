package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class readDataTest extends readData {
    storeData sd = new storeData();

    @Test
    void testPrintingOfDeveloperDetails() {

        String[] developerDetails = new String[]{"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"}       ;
        String developerDetails1 = """
                Mike Smith
                Edward Harrison
                Samantha Paulson
                Glenda Oberholzer
                """;
        assertEquals(developerDetails1, developerData(sd.developerDetails));
    }
    @Test
    void TestLongestDuration(){
        String testTaskDuration = "Glenda Oberholzer, 11";
        assertEquals(testTaskDuration, longestDuration(sd.taskDuration, sd.developerDetails));
    }

    @Test
    void testSearchSpecificTasks() {
        String taskToSearch = "Mike Smith, Create Login";
        assertEquals(taskToSearch, searchSpecificTask(sd.taskName, sd.developerDetails));
    }

    @Test
    void testSearchAllTasks() {
        String taskToSearch = "Create Reports";
        assertEquals(taskToSearch, searchAllTasks(sd.taskName, sd.developerDetails));
    }

    @Test
    void testDeleteTasks() {

        String taskToDelete = "Entry \"Create Reports\" successfully deleted";
        assertEquals(taskToDelete, deleteTask(sd.taskName));
    }
    @Test
    void testDisplayReport(){
        String testReport = """
                Mike Smith, Create Login, CR:1:IKE, 5, To Do
                Edward Harrison, Create Add Features, CR:2:ARD, 8, Doing
                Samantha Paulson, Create Reports, CR:3:THA, 2, Done
                Glenda Oberholzer, Add Arrays, AD:4:NDA, 11, To Do""";
        String test =  "Glenda Oberholzer, Add Arrays, AD:4:NDA, 11, To Do";
        assertEquals(test,displayDetails(sd.developerDetails,sd.taskName,sd.taskID, sd.taskDuration,sd.taskStatus));
    }
    @Test
    void test(){
        String test = "Samantha Paulson, Create Reports, 2";
        assertEquals(test,viewDoneDevelopers(sd.taskStatus,sd.developerDetails,sd.taskDuration, sd.taskName));
    }

}