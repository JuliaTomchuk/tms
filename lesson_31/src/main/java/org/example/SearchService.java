package org.example;


public class SearchService {

    public boolean search(Employee employee, Director director) {
        if (director.getSubordinates().contains(employee)) {
            return true;
        }

        long count = director.getSubordinates().stream().filter(e -> e instanceof Director).filter(e -> search(employee, (Director) e)).count();
        if (count > 0) {
            return true;
        }
        return false;
    }
}


