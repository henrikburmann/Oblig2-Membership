package no.ntnu.idatt2001.henriabu.henriabu;

public class SilverMembership extends Membership {

    private final float POINTS_SCALING_FACTOR = 1.2f;

    public int registerPoints(int bonusPointBalance, int newPoints){
        bonusPointBalance += newPoints*POINTS_SCALING_FACTOR;
        return Math.round(bonusPointBalance);
    }

    public String getMembershipName(){
        return "Silver";
    }
}
