package edu.parinya.softarchdesign.structural;

import java.util.HashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable{
    private Set<HealthcareServiceable> members = new HashSet<>();
    public void addMember(HealthcareServiceable newMember){ members.add(newMember); }
    public void removeMember(HealthcareServiceable delMember){ members.remove(delMember); }
    
    @Override
    public void service() {
        for(HealthcareServiceable member : members){
            member.service();
        }
    }

    @Override
    public double getPrice() {
        double totalPrice=0;
        for(HealthcareServiceable member : members){
            totalPrice+=member.getPrice();
        }
        return totalPrice;
    }
}