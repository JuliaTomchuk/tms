package org.example;

public class Main {
    public static void main(String[] args) {
        Notifier reportNotifier= new SimpleReportNotifier(Priority.ROUTINE);
        Notifier emailNotifier =  new EmailNotifier(Priority.IMPORTANT);
        Notifier asapNotifier = new SMSNotifier(Priority.ASAP);

        reportNotifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(asapNotifier);

       // reportNotifier.notifierManager(Priority.ROUTINE,"Everything Ok");
        //reportNotifier.notifierManager(Priority.IMPORTANT,"Not so good");
       reportNotifier.notifierManager(Priority.ASAP,"bad");
    }
}