package com.ironhack.main;

import com.ironhack.classes.Lead;
import com.ironhack.classes.Opportunity;

import java.util.HashMap;
import java.util.Scanner;

import static com.ironhack.utils.Command.*;

public class Main {

    public static void main(String[] args) {
        //Create a Scanner to collect user input
        Scanner myScanner = new Scanner(System.in);

        HashMap<Integer, Lead> leadList=new HashMap<>();
        HashMap<Integer, Opportunity> opportunitiesList=new HashMap<>();

        leadList.put(0,new Lead("Ana Campos",
                                "647321563",
                                "ana@email.com",
                                "Transportes Campos S.L."));
        leadList.put(1,new Lead("Carlos Botijo",
                                "647321593",
                                "carlos@email.com",
                                "Transportes Botijo S.L."));

        System.out.println("Welcome to the best CRM you have ever seen");

        String userInput="";

        while (!userInput.equals("exit")){
            showMainMenu();
            // Get input from the user
            userInput = myScanner.nextLine()
                                 .toLowerCase()
                                 .trim();

            commandReader(userInput, leadList, opportunitiesList);

        }
    }


    public static void showMainMenu(){
        System.out.println("What do you want to do?:");
        System.out.println("- new lead");
        System.out.println("- convert \\id\\");
        System.out.println("- show opportunities");
        System.out.println("- show leads");
        System.out.println("- lookup opportunity \\id\\");
        System.out.println("- lookup lead \\id\\");
        System.out.println("- close-lost \\id\\");
        System.out.println("- close-won \\id\\");
        System.out.println("- exit");
    }


}
