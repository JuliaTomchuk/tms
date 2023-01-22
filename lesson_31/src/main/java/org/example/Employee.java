package org.example;

import java.util.Objects;

public abstract class Employee {

    private String name;
    private String surname;
    private Position position;
    private int experience;


    public Employee() {
    }


    public Employee(String name, String surname, Position position, int experience) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.experience = experience;

    }

    public int getSalary(int baseRate) throws SalaryException {
        int salary = baseRate * experience * position.rate;
        if (salary <= 0) {
            throw new SalaryException("Salary is less or equals zero");
        }
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getExperience() == employee.getExperience() && getName().equals(employee.getName()) && getSurname().equals(employee.getSurname()) && getPosition() == employee.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getPosition(), getExperience());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position=" + position +
                ", experience=" + experience +
                '}';
    }
}
