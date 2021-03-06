package edu.parinya.softarchdesign.structural;

public abstract class HealthcareWorkerDecorator extends HealthcareWorker {
    protected HealthcareServiceable worker;

    public HealthcareWorkerDecorator(HealthcareServiceable worker) {
        super((HealthcareWorker) worker);
        this.worker = worker;
    }

    public void service() {
        worker.service();
    }

    public double getPrice() {
        return worker.getPrice();
    }
}
