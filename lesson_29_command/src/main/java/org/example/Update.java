package org.example;

public class Update implements Command{
    @Override
    public void execute() {
        System.out.println("Update ");
    }
}
