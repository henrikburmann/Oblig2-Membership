package no.ntnu.idatt2001.henriabu.henriabu;

public class GoldMemberShip extends Membership {
    private final float POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
    private final float POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;

    public int registerPoints(int bonusPointBalance, int newPoints){
        if (bonusPointBalance<90000){
            bonusPointBalance += newPoints * POINTS_SCALING_FACTOR_LEVEL_1;
        }
        else{
            bonusPointBalance += newPoints * POINTS_SCALING_FACTOR_LEVEL_2;
        }
        return Math.round(bonusPointBalance);
    }
    public String getMembershipName(){
        return "Gold";
    }
}
