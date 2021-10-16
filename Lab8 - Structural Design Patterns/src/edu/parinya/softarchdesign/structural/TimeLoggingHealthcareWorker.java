package edu.parinya.softarchdesign.structural;

import java.util.Date;

public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator{
    public TimeLoggingHealthcareWorker(HealthcareServiceable worker) {
        super(worker);
        System.out.println("Decorate "+super.getName()+" with TimeLogging.");
    }
    public void service() {
        System.out.print(new Date() + ": ");
        super.service();
    }
}
