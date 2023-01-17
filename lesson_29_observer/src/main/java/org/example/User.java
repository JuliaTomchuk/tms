package org.example;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class User implements PropertyChangeListener {
    private String name;
    private String message;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        message = (String) evt.getNewValue();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getName().equals(user.getName()) && getMessage().equals(user.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getMessage());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
