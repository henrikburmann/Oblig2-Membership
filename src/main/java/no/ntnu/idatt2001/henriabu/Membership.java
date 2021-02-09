package no.ntnu.idatt2001.henriabu;

public abstract class Membership {

    public Membership(){}

    public abstract int registerPoints(int bonusPointBalance, int newPoints);

    public abstract String getMembershipName();

}
