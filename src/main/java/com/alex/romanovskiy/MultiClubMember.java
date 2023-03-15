package com.alex.romanovskiy;

public class MultiClubMember extends Member {
    private int memberShipPoints;


    public MultiClubMember(char memberType, int memberId, String name, double fees, int memberShipPoints) {
        super(memberType, memberId, name, fees);
        this.memberShipPoints = memberShipPoints;
    }

    public void setMemberShipPoints(int memberShipPoints) {
        this.memberShipPoints = memberShipPoints;
    }

    public int getMemberShipPoints() {
        return this.memberShipPoints;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + memberShipPoints;
    }
}
