package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int baseRate = 100;

        Employee worker1 = new Worker("John", "Brown", 2);
        Employee worker2 = new Worker("Ann", "Smith", 5);
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(worker1);
        employeeList.add(worker2);


        Director directorMain = new Director("Karl", "Jones", 8, employeeList);

        int worker1Salary = worker1.getSalary(baseRate);


        int worker2Salary = worker2.getSalary(baseRate);


        int directorMainSalary = directorMain.getSalary(baseRate);


        System.out.println(directorMain + " salary: " + directorMainSalary);
        System.out.println(worker1 + " salary: " + worker1Salary);
        System.out.println(worker2 + "salary: " + worker2Salary);

        System.out.println("-------------------------------------------------------------------------------");

        Employee worker3 = new Worker("Jane", "Wilson", 10);
        List<Employee> employeeList1 = new ArrayList<>();
        employeeList1.add(worker3);

        Director director = new Director("Elizabeth", "James", 3, employeeList1);

        directorMain.addSubordinate(director);

        System.out.println(directorMain);

        System.out.println("search result---------------------------------------------------------------");

        SearchService searchService = new SearchService();

        Employee result = searchService.search("Jane", "Wilson", directorMain);

        System.out.println(result);

    }
}