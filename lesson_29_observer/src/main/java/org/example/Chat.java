package org.example;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class Chat {

    private String message;

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public void removeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        propertyChangeSupport.firePropertyChange("newChat", this.message, message);
        this.message = message;
    }
}

