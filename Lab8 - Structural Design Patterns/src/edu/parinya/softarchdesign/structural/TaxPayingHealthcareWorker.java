package edu.parinya.softarchdesign.structural;

public class TaxPayingHealthcareWorker extends HealthcareWorkerDecorator{
    public TaxPayingHealthcareWorker(HealthcareServiceable worker) {
        super(worker);
        System.out.println("Decorate "+super.getName()+" with TaxPaying.");
    }

    public double getPrice() {
        return super.getPrice()*1.10;
    }
}
