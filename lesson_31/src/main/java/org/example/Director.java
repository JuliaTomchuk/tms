package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Director extends Employee {

    private List<Employee> subordinates;

    public Director() {
        super();
        subordinates = new ArrayList<>();
        position = Position.DIRECTOR;
    }

    public Director(String name, String surname, int experience, List<Employee> subordinates) {
        super(name, surname, experience);
        this.subordinates = subordinates;
        position = Position.DIRECTOR;
    }


    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public Employee getSubordinate(int index) {

        return subordinates.get(index);
    }

    public boolean removeSubordinate(Employee employee) {

        return subordinates.remove(employee);
    }

    @Override
    public int getSalary(int baseRate) {
        int salary = baseRate * super.getExperience() * position.rate + subordinates.size();
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Director director)) return false;
        if (!super.equals(o)) return false;
        return getSubordinates().equals(director.getSubordinates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSubordinates());
    }

    @Override
    public String toString() {
        return "Director{" + super.toString() +
                "subordinates=" + subordinates +
                '}';
    }
}
