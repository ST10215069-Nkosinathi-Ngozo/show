package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class tasksTest extends tasks {
    @Test
    void testTaskDescription(){
        String taskDescriptionTest1 = "Create Login to authenticate users";
        String taskDescriptionTest2 = "Create Add Task feature to add task users";
        assertEquals(true,checkTaskDescription(taskDescriptionTest1));
        assertEquals(true,checkTaskDescription(taskDescriptionTest2));

    }
    @Test
    void testTaskID(){
        String taskID1 = "LO:1:BYN";
        String taskID2 =  "AD:1:IKE";
        assertEquals(taskID1,(checkTaskID("Robyn","Harrison",1,"Login Feature")));
        assertEquals(taskID2,(checkTaskID("Mike","Smith",1,"Add Task Feature")));

    }
    @Test
    void testReturnTotalHours(){

        assertEquals(89,returnTotalHours());
    }

}