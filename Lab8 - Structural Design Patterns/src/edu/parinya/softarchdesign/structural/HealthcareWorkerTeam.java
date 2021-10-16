package edu.parinya.softarchdesign.structural;

import java.util.LinkedHashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable{
    private Set<HealthcareServiceable> members = new LinkedHashSet<>();
    public void addMember(HealthcareServiceable newMember) {
        members.add(newMember);
    }
    public void removeMember(HealthcareServiceable delMember){
        members.remove(delMember);
    }

    @Override
    public void service() {
        for(HealthcareServiceable memberService : members){
            memberService.service();
        }
    }

    @Override
    public double getPrice() {
        double totalPrice = 0;
        for(HealthcareServiceable memberPrice : members){
            totalPrice += memberPrice.getPrice();
        }
        return totalPrice;
    }
}