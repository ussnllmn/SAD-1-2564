package edu.parinya.softarchdesign.structural;

import java.util.HashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable{
    private Set<HealthcareServiceable> member = new HashSet<>();
    public void addMember(HealthcareServiceable newMember){this.member.add(newMember)}
    public void removeMember(HealthcareServiceable delMember){this.member.remove(delMember)}
    
    @Override
    public void service() {

    }

    @Override
    public double getPrice() {
        return 0;
    }
}
