package org.example;

public abstract class Notifier {
    private int priority;
    private Notifier nextNotifier;

    public Notifier(int priority){
        this.priority=priority;
    }
    public void setNextNotifier(Notifier notifier){
        this.nextNotifier=notifier;
    }
    public void notifierManager(int level,String message){
        if(level>=Priority.ASAP){
            write(message);
        }
        if(nextNotifier!=null){
            nextNotifier.notifierManager(level,message);
        }
    }
    public abstract void write(String message);
}
