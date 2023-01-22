package org.example;

public class SalaryException extends Exception {

    public SalaryException() {
    }

    public SalaryException(String message) {
        super(message);
    }

    public SalaryException(String message, Exception e) {
        super(message, e);
    }

    public SalaryException(Exception e) {
        super(e);
    }


}
