package com.twx.eot.exceptions;

public class WrongInputException extends Throwable {
    public WrongInputException() {
        super("Wrong input! Please give your input again");
    }
}
