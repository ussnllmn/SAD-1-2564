package edu.parinya.softarchdesign.structural;

import java.util.HashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable{
    private Set<HealthcareServiceable> member = new HashSet<>();
    public void addMember(HealthcareServiceable newMember){ member.add(newMember); }
    public void removeMember(HealthcareServiceable delMember){ member.remove(delMember); }
    
    @Override
    public void service() {
        for(HealthcareServiceable member : member){
            member.service();
        }
    }

    @Override
    public double getPrice() {
        double totalPrice=0;
        for(HealthcareServiceable member : member){
            totalPrice += member.getPrice();
        }
        return totalPrice;
    }
}