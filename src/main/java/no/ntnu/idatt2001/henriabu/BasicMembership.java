package no.ntnu.idatt2001.henriabu;

public class BasicMembership extends Membership {


    public int registerPoints(int bonusPointBalance, int newPoints){
        bonusPointBalance += newPoints;
        return bonusPointBalance;
    }

    public String getMembershipName(){
        return "Basic";
    }
}
