package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int baseRate = 100;

        Employee worker1 = new Worker("John", "Brown", Position.WORKER, 2);
        Employee worker2 = new Worker("Ann", "Smith", Position.WORKER, 5);
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(worker1);
        employeeList.add(worker2);


        Director directorMain = new Director("Karl", "Jones", Position.DIRECTOR, 8, employeeList);

        int worker1Salary;

        try {
            worker1Salary = worker1.getSalary(baseRate);
        } catch (SalaryException e) {
            throw new RuntimeException(e);
        }

        int worker2Salary;

        try {
            worker2Salary = worker2.getSalary(baseRate);
        } catch (SalaryException e) {
            throw new RuntimeException(e);
        }

        int directorMainSalary;

        try {
            directorMainSalary = directorMain.getSalary(baseRate);
        } catch (SalaryException e) {
            throw new RuntimeException(e);
        }

        System.out.println(directorMain + " salary: " + directorMainSalary);
        System.out.println(worker1 + " salary: " + worker1Salary);
        System.out.println(worker2 + "salary: " + worker2Salary);

        System.out.println("-------------------------------------------------------------------------------");

        Employee worker3 = new Worker("Jane", "Wilson", Position.WORKER, 10);
        List<Employee> employeeList1 = new ArrayList<>();
        employeeList1.add(worker3);

        Director director = new Director("Elizabeth", "James", Position.DIRECTOR, 3, employeeList1);

        directorMain.addSubordinate(director);

        System.out.println(directorMain);

        System.out.println("search result---------------------------------------------------------------");

        SearchService searchService = new SearchService();
        boolean isPresent = searchService.search(worker3, directorMain);

        System.out.println(isPresent);

    }
}