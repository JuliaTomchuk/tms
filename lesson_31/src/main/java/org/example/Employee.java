package org.example;

import java.util.Objects;

public abstract class Employee {

    private String name;
    private String surname;
    private int experience;
    protected Position position;


    public Employee() {
    }

    public Position getPosition() {
        return position;
    }

    public Employee(String name, String surname, int experience) {
        this.name = name;
        this.surname = surname;
        this.experience = experience;

    }

    public int getSalary(int baseRate) {
        int salary = baseRate * experience * position.rate;

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
        return Objects.hash(getName(), getSurname(), getExperience(), getPosition());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", experience=" + experience +
                ", position=" + position +
                '}';
    }
}

