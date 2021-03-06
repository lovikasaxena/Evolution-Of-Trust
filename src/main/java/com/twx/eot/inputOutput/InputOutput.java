package com.twx.eot.inputOutput;

import com.twx.eot.exceptions.WrongInputException;

import java.util.Scanner;

public class InputOutput {

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
         String input = scanner.next();
         try {
             if (!input.equals("CHEAT") && !input.equals("COOPERATE")) {
                 throw new WrongInputException();
             }
             return input;
         }
         catch (WrongInputException e){
             InputOutput inputOutput = new InputOutput();
             inputOutput.display(e.getMessage());
             return getInput();
         }
        //return null;
    }

   public void display(String string){
        System.out.println(string);
    }
}
