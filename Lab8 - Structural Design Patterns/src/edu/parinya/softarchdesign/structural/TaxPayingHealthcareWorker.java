package edu.parinya.softarchdesign.structural;

public class TaxPayingHealthcareWorker extends HealthcareWorkerDecorator{

    public TaxPayingHealthcareWorker(HealthcareServiceable worker) {
        super(worker);
    }
    public double getPrice() {
        return super.getPrice() * 0.10;
    }
}
