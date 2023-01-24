package org.example;


import java.util.Optional;

public class SearchService {

    public Employee search(String name, String surname, Director director) {

        Optional<Employee> employeeOptional = director.getSubordinates().stream().filter(e -> e.getName().equals(name) && e.getSurname().equals(surname)).findFirst();

        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        } else {


            for (Employee e : director.getSubordinates()) {
                if (e instanceof Director) {
                    Employee employee = search(name, surname, (Director) e);
                    if (employee.getName() != null) {
                        return employee;
                    }
                }
            }
            return new Worker();
        }

    }

}


